package com.laivi.knowledge.test;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonList;
import com.laivi.knowledge.basic.util.DataUtil;
import com.laivi.knowledge.basic.util.JsonUtil;
import com.laivi.knowledge.book.model.po.Chapter;
import com.laivi.knowledge.book.util.BookChapterUtil;
import com.laivi.knowledge.common.model.type.FavoriteType;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-4
 */
public class UtilTest {
	
	@Test
	public void testDataUtil() throws ErrorException{
		String str="字符串不合法abc不合法";
		System.out.println(DataUtil.getDefaultChar(str,9));
	}
    @Test
    public void testEnumJson()throws ErrorException{
        FavoriteType type=FavoriteType.ARTICLE;
        System.out.println(JsonUtil.parseArray(type));
    }
    @Test
    public void testJsonList()throws ErrorException{
    	JsonList jsonList=new JsonList();
    	jsonList.add("abc");
    	jsonList.add("abe");
    	jsonList.add("abf");
    	System.out.print(jsonList.toString());
    }
    
    @Test
    public void testBook()throws ErrorException{
    	File file=new File("D:\\Media\\Book\\book\\采花录.txt");
    	List<Chapter> chapterList=BookChapterUtil.getChapters(file);
    	System.out.println("size:"+chapterList.size());
    }

}
