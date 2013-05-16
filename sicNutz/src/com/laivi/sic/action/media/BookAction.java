package com.laivi.sic.action.media;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Files;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.json.JsonItemList;
import com.laivi.sic.model.po.media.Book;
import com.laivi.sic.model.po.media.Chapter;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.util.basic.FileUtil;
import com.laivi.sic.util.book.BookChapterUtil;

@IocBean
@At("/media/book")
public class BookAction extends ABasicDBAction<Book> {
	@At
	@AdaptBy(type = UploadAdaptor.class,args="ioc:upload")
	public Object upload(@Param("pictures")TempFile[] tempFiles){
		JsonItemList jsonList=new JsonItemList();
		for(TempFile tempFile:tempFiles){
			File file=tempFile.getFile();
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			Book book=new Book(tempFile.getMeta().getFileLocalName(),uuid+"."+Files.getSuffixName(file).toLowerCase());
			book.setUserId(getUserId());
			book.setPrice(0);
			dao.insert(book);
			List<Chapter> chapterList=BookChapterUtil.getChapters(file);
			for(Chapter chapter:chapterList){
				chapter.setBookId(book.getId());
				dao.insert(chapter);
			}
			jsonList.createItem().add("id",book.getId()).add("name", book.getName())
								 .add("size", file.length()).add("delete_type","GET")
								 .add("url","").add("delete_url","");
			String dest=this.getRealPath("/upload/book/"+uuid)+"."+Files.getSuffixName(file).toLowerCase();
			//String smallPath = this.getRealPath("/upload/music/"+uuid) + "_128x128." + Files.getSuffixName(file).toLowerCase();
			try{
				//Images.zoomScale(file, new File(smallPath), 128, 128,Color.BLACK);
				file.renameTo(new File(dest));
			}catch(Throwable e){
				e.printStackTrace();
			}
		}
		return jsonList.getRoot();
	}
	
	@At
	@Ok("raw")
	public File download(String fileName){
		return FileUtil.getFile(this.getRealPath("/upload/book/"+fileName));
	}
	
	@At
	@CheckValue
	public Response add(@Param("::book.")Book book){
		book.setUserId(this.getUserId());
		book.setCreateIs(true);
		dao.insert(book);
		return success();
	}
	
	@At
	public Response update(@Param("::book.")Book book){
		Book dBook=dao.fetch(Book.class, book.getId());
		dBook.setName(book.getName());
		dBook.setDescription(book.getDescription());
		dBook.setTagId(book.getTagId());
		dBook.setPrice(book.getPrice());
		dao.update(dBook);
		return success();
	}
	
	@At
	public Object listBook(@Param("::page")Pager page,@Param("::book")Book book){
		return list(page,Cnd.where("createIs","=", book.isCreateIs()));
	}
	@At
	public Response addUserBookShelf(){
		return success();
	}

	@Override
	public Class<Book> getEntityClass() {
		return Book.class;
	}

}
