package com.laivi.knowledge.tool;

import com.laivi.knowledge.tool.crawler.LinkFilter;

public interface Parsers {
	
	<T> T parser(String url,LinkFilter filter);

	LinkFilter getLinkFilter();
}
