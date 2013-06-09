package com.laivi.crawler;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.laivi.crawler.model.LinkDB;
import com.laivi.crawler.model.LinkParser;
import com.laivi.crawler.parser.Parsers;


public class Crawler {
	/* 使用种子 url 初始化 URL 队列*/
    private void initCrawlerWithSeeds(String[] seeds) {
    	LinkDB.clean();
        for (int i = 0; i < seeds.length; i++) {
            LinkDB.addUnvisitedUrl(seeds[i]);
        }
    }
    
    public List<Object> crawling(Parsers parser){
    	List<Object> objs=new ArrayList<Object>();
    	initCrawlerWithSeeds(parser.getSeeds());
    	BufferedWriter bw=null;
    	try {
			bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("time-url.txt",true)));
			
			while(!LinkDB.unVisitedUrlsEmpty()&&LinkDB.getVisitedUrlNum()<100){
	    		 //队头 URL 出对
	            String visitUrl = LinkDB.unVisitedUrlDeQueue();
	            if (visitUrl == null) {
	                continue;
	            }
	            LinkDB.addVisitedUrl(visitUrl);
	            for(String seed:LinkParser.extracLinks(visitUrl, parser.getParserLinkFilter())){
	            	LinkDB.addUnvisitedUrl(seed);
	            }
	            for(String link:LinkParser.extracLinks(visitUrl,parser.getLinkFilter())){
	            	//objs.add(parser.parser(link));
	            	if(!LinkDB.isVisited(link)){
	            		LinkDB.addVisitedUrl(link);
	            		System.out.println(link);
		            	bw.write(link);
		            	bw.newLine();
	            	}
	            	
	            }
	    	}
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(bw!=null){
				try {
					bw.flush();
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    	
    	return objs;
    }
    
    
}

