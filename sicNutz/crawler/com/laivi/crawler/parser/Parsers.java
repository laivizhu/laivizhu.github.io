package com.laivi.crawler.parser;

import com.laivi.crawler.model.LinkFilter;

public interface Parsers {
	
	<T> T parser(String url);

	LinkFilter getLinkFilter();
	
	String[] getSeeds();
	
	LinkFilter getParserLinkFilter();
}
