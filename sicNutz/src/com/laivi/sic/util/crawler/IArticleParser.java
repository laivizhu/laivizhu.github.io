package com.laivi.sic.util.crawler;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;

import com.laivi.sic.model.po.blog.Article;

public interface IArticleParser {

	Article parserArticle(String url,LinkFilter filter);
	
	String getTitle(Parser parser,LinkFilter filter);
	
	String getContent(NodeFilter filter,Parser parser);
}
