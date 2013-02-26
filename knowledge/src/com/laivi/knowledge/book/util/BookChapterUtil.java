package com.laivi.knowledge.book.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.laivi.knowledge.book.model.po.Chapter;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 17, 2013
 */
public class BookChapterUtil {
	
	public static List<Chapter> getChapters(File book){
		List<Chapter> chapterList=new ArrayList<Chapter>();
		BufferedReader br=null;
		try {
			br=new BufferedReader(new InputStreamReader(new FileInputStream(book),"gbk"));
			String regex=".*第.*章.*";
			String line;
			Chapter chapter=new Chapter();
			StringBuilder content=new StringBuilder();
			int i=0;
			while((line=br.readLine())!=null){
				if(Pattern.matches(regex, line)){
					i++;
					if(i>1){
						chapter.setContent(content.toString());
						content=new StringBuilder();
						chapterList.add(chapter);
						chapter=new Chapter();
					}
					chapter.setTitle(line);
					chapter.setIndexChapter(i);
				}else{
					if(i>=1){
						content.append(line+"<br>");
					}
				}
			}
			chapter.setContent(content.toString());
			chapterList.add(chapter);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return chapterList;
	}
	
	
	
	

}
