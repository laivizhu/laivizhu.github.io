package com.laivi.knowledge.book.action;

import java.io.File;

import javax.annotation.Resource;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.action.ALBasicAction;
import com.laivi.knowledge.basic.model.constants.AppConstants;
import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.model.to.CriterionList;
import com.laivi.knowledge.basic.service.LBasicService;
import com.laivi.knowledge.basic.util.DataUtil;
import com.laivi.knowledge.basic.util.FileUtil;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.book.model.constants.BookConstants;
import com.laivi.knowledge.book.model.po.Book;
import com.laivi.knowledge.book.model.po.BookMark;
import com.laivi.knowledge.book.model.po.Chapter;
import com.laivi.knowledge.book.service.BookService;
import com.laivi.knowledge.user.model.po.User;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 17, 2013
 */
@SuppressWarnings("serial")
public class BookAction extends ALBasicAction<Book> {
	private BookService bookService;
	private LBasicService<Chapter> chapterService;
	private LBasicService<BookMark> bookMarkService;
	private Book book;
	private Chapter chapter;
	private File[] books;
	private String[] booksFileName;
	private String dir;
	public BookAction(){
		this.downLoadPath=BookConstants.BOOK_DOWNLOAD;
	}
	
	public String add()throws Exception{
		ParamAssert.isNotEmptyString(book.getName(), "书籍名不能为空",true);
		ParamAssert.isNotEmptyString(book.getDescription(), "描述不能为空",true);
		book.setUserId(this.getCurrentUserId());
		book.setCreateIs(true);
		this.basicService.add(book);
		return response(true);
	}
	
	public String addUserBookShelf()throws Exception{
		long userId=this.getCurrentUserId();
		Book book=this.basicService.getObject(this.getObjectClass(), id);
		ParamAssert.isTrue(userId!=book.getUserId(), "用户是该书的创作者", true);
		ParamAssert.isTrue(!DataUtil.isIncludeId(userId, book.getUserIds()), "用户书架已包含该书",true);
		User user=this.userService.getObject(User.class, userId);
		ParamAssert.isTrue(user.getScore()>=book.getPrice(), "分数不够，不能加入书架，请先充值！",true);
		if(DataUtil.notEmptyString(book.getUserIds())){
			book.setUserIds(book.getUserIds()+","+userId);
		}else{
			book.setUserIds(userId+AppConstants.EMPTY);
		}
		user.setScore(user.getScore()-book.getPrice());
		this.userService.modify(user);
		this.basicService.modify(book);
		return response(true);
	}
	
	public String update()throws Exception{
		return response();
	}
	
	public String upload()throws Exception{
		if(books!=null){
			return response(bookService.upload(books, booksFileName, this.getRealPath(BookConstants.BOOK_UPLOADPATH), this.getCurrentUserId()));
		}else{
			return response(false);
		}
	}
	
	public String delete()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		this.bookService.remove(this.getObjectClass(),id);
		File file=FileUtil.getFile(this.getRealPath(BookConstants.BOOK_UPLOADPATH)+"\\"+fileName);
		if(file.exists()){
			file.delete();
		}
		chapterService.executeSql("delete from t_chapter where bookId="+id, null);
		return response(true);
	}
	
	public String list()throws Exception{
		if(this.getCurrentUser()!=null){
			long userId=this.getCurrentUserId();
			this.conditions=CriterionList.CreateCriterion().put(
					Restrictions.or(
							Restrictions.eq("userId", userId), 
							Restrictions.or(
									Restrictions.like("userIds", userId+AppConstants.EMPTY,MatchMode.START), 
									Restrictions.or(
											Restrictions.like("userIds", ","+userId,MatchMode.END),
											Restrictions.like("userIds", ","+userId+",",MatchMode.ANYWHERE)))));
		}
		if(book!=null){
			if(conditions!=null){
				this.conditions=CriterionList.CreateCriterion();
			}
			conditions.put(Restrictions.eq("createIs", book.isCreateIs()));
		}
		return response(list(true,false));
	}
	
	public String tagCategoryList()throws Exception{
		this.conditions=CriterionList.CreateCriterion()
				.put(Restrictions.eq("tagId", book.getTagId()));
		return response(list(true,false));
	}
	
	public String addChapter()throws Exception{
		ParamAssert.isNotEmptyString(this.chapter.getTitle(),"章节标题",true);
		ParamAssert.isNotEmptyString(this.chapter.getContent(),"章节内容",true);
		Integer value = (Integer) chapterService.getObjectByHql("select max(c.indexChapter) from Chapter c where bookId="+chapter.getBookId(), null);
		if(value==null){
			chapter.setIndexChapter(1);
		}else{
			chapter.setIndexChapter(value+1);
		}
		this.chapterService.add(chapter);
		return response(true);
	}
	
	public String updateChapter()throws Exception{
		
		return response();
	}
	
	
	public String deleteChapter()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		this.chapterService.remove(Chapter.class, id);
		return response(true);
	}
	
	public String getBookChapter()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		Chapter chapter=this.chapterService.getObject(Chapter.class, id);
		JsonItem item=null;
		String msg=null;
		if(DataUtil.notEmptyString(dir)){
			this.conditions=CriterionList.CreateCriterion().put(Restrictions.eq("bookId", chapter.getBookId()));
			if("pre".equals(dir)){
				this.conditions.put(Restrictions.lt("indexChapter", chapter.getIndexChapter())).put(Order.desc("indexChapter"));
				msg="已经是第一章了";
			}else{
				this.conditions.put(Restrictions.gt("indexChapter", chapter.getIndexChapter())).put(Order.asc("indexChapter"));
				msg="已经是最后一章了";
			}
			Chapter dirChapter=this.chapterService.getObject(Chapter.class, conditions);
			if(dirChapter==null){
				throw new ErrorException(msg,true);
			}else{
				item=this.getChapter(dirChapter, fold);
			}
		}else{
			item=this.getChapter(chapter, fold);
		}
		return response(item.toFormDataString(true));
	}
	
	public String listChapter()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		this.conditions=CriterionList.CreateCriterion();
		this.conditions.put(Restrictions.eq("bookId", id)).add(Order.asc("indexChapter"));
		JsonItemList jsonList=new JsonItemList();
		for(Chapter chapter:this.chapterService.getList(Chapter.class, conditions, start, limit)){
			jsonList.add(this.getChapter(chapter, true));
		}
		return response(jsonList.toPageString(this.chapterService.getCount(Chapter.class, conditions)));
	}
	
	private JsonItem getChapter(Chapter chapter,boolean isSub) throws ErrorException{
		JsonItem item=new JsonItem();
		item.add("id", chapter.getId())
		.add("title", chapter.getTitle())
		.add("content", isSub?DataUtil.getDefaultChar(chapter.getContent()):chapter.getContent())
		.add("bookId", chapter.getBookId())
		.add("index", chapter.getIndexChapter());
		return item;
	}
	
	public String addBookMark()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		long userId=this.getCurrentUserId();
		this.conditions=CriterionList.CreateCriterion()
				.put(Restrictions.eq("chapterId", id))
				.put(Restrictions.eq("userId",userId));
		ParamAssert.isTrue(this.bookMarkService.getCount(BookMark.class, conditions)==0, "error.object.hasExist");
		BookMark bookMark=new BookMark(userId,id);
		this.bookMarkService.add(bookMark);
		return response(true);
	}
	
	public String bookMarklist()throws Exception{
		this.conditions=CriterionList.CreateCriterion()
				.put(Restrictions.eq("userId",this.getCurrentUserId()))
				.put(Order.desc("createDate"));
		JsonItemList jsonList=new JsonItemList();
		for(BookMark bookMark:this.bookMarkService.getList(BookMark.class, conditions, start, limit)){
			jsonList.createItem().add("id", bookMark.getId())
			.add("chapter", this.chapterService.getObject(Chapter.class, bookMark.getChapterId()))
			.add("userId", bookMark.getUserId());
		}
		return response(jsonList.toPageString(this.bookMarkService.getCount(BookMark.class, conditions)));
	}
	
	public String deleteBookMark()throws Exception{
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		this.bookMarkService.remove(BookMark.class, id);
		return response(true);
	}
	
	@Override
	public JsonItemList getSearchComboList() throws ErrorException {
		return null;
	}

	@Override
	public JsonItem getJsonItem(Book object, boolean isSub) throws Exception {
		JsonItem item=new JsonItem();
		item.add("id", object.getId())
		.add("name", object.getName())
		.add("description", object.getDescription())
		.add("price", object.getPrice());
		if(object.isCreateIs()){
			item.add("path", item);
		}else{
			item.add("path",FileUtil.getFileUrl("book_downLoad.action",object.getPath(),object.getName()));
		}
		return item;
	}

	@Override
	public Class<Book> getObjectClass() throws Exception {
		return Book.class;
	}
	
	@Resource(name="LBasicService")
	public void setBasicService(LBasicService<Book> basicService){
		this.basicService=basicService;
	}
	
	@Resource(name="LBasicService")
	public void setChapterService(LBasicService<Chapter> chapterService) {
		this.chapterService = chapterService;
	}
	
	@Resource(name="LBasicService")
	public void setBookMarkService(LBasicService<BookMark> bookMarkService) {
		this.bookMarkService = bookMarkService;
	}

	@Resource(name="BookService")
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	@Resource(name="LBasicService")
	public void setUserService(LBasicService<User> userService){
		this.userService=userService;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public File[] getBooks() {
		return books;
	}

	public void setBooks(File[] books) {
		this.books = books;
	}

	public String[] getBooksFileName() {
		return booksFileName;
	}

	public void setBooksFileName(String[] booksFileName) {
		this.booksFileName = booksFileName;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public Chapter getChapter() {
		return chapter;
	}
	
}
