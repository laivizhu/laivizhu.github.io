package com.laivi.knowledge.tool.crawler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.laivi.knowledge.knowledge.model.po.Article;
import com.laivi.knowledge.tool.ArticleParser;
import com.laivi.knowledge.tool.Parsers;

public class Crawler {
	Parsers parser=new ArticleParser();
    /* 使用种子 url 初始化 URL 队列*/
    private void initCrawlerWithSeeds(String[] seeds) {
        for (int i = 0; i < seeds.length; i++) {
            LinkDB.addUnvisitedUrl(seeds[i]);
        }
    }

    /* 爬取方法*/
    public List<Article> crawlingArticle(String[] seeds,LinkFilter filter) {
    	List<Article> articleList=new ArrayList<Article>();
        //初始化 URL 队列
        initCrawlerWithSeeds(seeds);
        //循环条件：待抓取的链接不空且抓取的网页不多于 1000
        while (!LinkDB.unVisitedUrlsEmpty() && LinkDB.getVisitedUrlNum() <= 10) {
            //队头 URL 出对
            String visitUrl = LinkDB.unVisitedUrlDeQueue();
            if (visitUrl == null) {
                continue;
            }
            LinkDB.addVisitedUrl(visitUrl);
            Set<String> links = LinkParser.extracLinks(visitUrl,filter);
            for (String link : links) {
                LinkDB.addUnvisitedUrl(link);
                System.out.println(link);
                Article article=parser.parser(link,filter);
                articleList.add(article);
            }
        }
        return articleList;
    }
}

