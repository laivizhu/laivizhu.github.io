package com.laivi.knowledge.book.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.laivi.knowledge.basic.dao.LBasicDao;
import com.laivi.knowledge.basic.model.exception.ErrorFileException;
import com.laivi.knowledge.basic.service.LBasicService;
import com.laivi.knowledge.basic.util.FileUtil;
import com.laivi.knowledge.book.model.po.Book;
import com.laivi.knowledge.book.model.po.Chapter;
import com.laivi.knowledge.book.util.BookChapterUtil;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 18, 2013
 */
@Service("BookService")
public class BookService extends LBasicService<Book> implements IBookService {
	private LBasicDao<Chapter> chapterDao;

	@Resource(name="LBasicDao")
	public void setChapterDao(LBasicDao<Chapter> chapterDao) {
		this.chapterDao = chapterDao;
	}

	@Override
	public JSONArray upload(File[] books, String[] booksFileName, String path,long userId) throws ErrorFileException {
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<books.length;i++){
			Book book=new Book(booksFileName[i].substring(0, booksFileName[i].indexOf(".")),FileUtil.saveCodingFile(books[i], path, booksFileName[i]),userId);
			this.add(book);
			List<Chapter> chapterList=BookChapterUtil.getChapters(books[i]);
			for(Chapter chapter:chapterList){
				chapter.setBookId(book.getId());
				chapterDao.add(chapter);
			}
			JSONObject jsono = new JSONObject();
			jsono.put("id", book.getId());
			jsono.put("name", booksFileName[i]);
			jsono.put("size",books[i].length());
			jsono.put("url", "book_downLoad.action?fileName="+booksFileName[i]);
			jsono.put("delete_url","book_delete.action?id="+book.getId()+"&fileName="+book.getPath());
			jsono.put("delete_type","GET");
			jsonArray.add(jsono);
		}
		return jsonArray;
	}

	
}
