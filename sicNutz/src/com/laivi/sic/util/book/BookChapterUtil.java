package com.laivi.sic.util.book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import com.laivi.sic.model.exception.ErrorException;
import com.laivi.sic.model.po.media.Chapter;

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
			br=new BufferedReader(new InputStreamReader(new FileInputStream(book),"utf-8"));
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
	
	public static String getBookFile(List<Chapter> chapters,String path) throws ErrorException {
        String uuid=null;
        BufferedWriter bw=null;
		try {
            uuid= UUID.randomUUID().toString();
			bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path+uuid)),"utf-8"));
			for(Chapter chapter:chapters){
                bw.write(chapter.getTitle()+"\t\n");
                String[] lines=chapter.getContent().split("<br>");
                for(String line:lines){
                    bw.write(line+"\t\n");
                }
			}
		} catch (FileNotFoundException e) {
            throw new ErrorException("文件没找到",true);
		} catch (IOException e) {
            throw new ErrorException("文件读取错误",true);
        } finally {
            try {
                if(bw!=null){
                    bw.close();
                }
            } catch (IOException e) {
                throw new ErrorException("文件读取错误",true);
            }
        }
        return uuid;
	}
}
