package com.laivi.sic.test;

import com.laivi.crawler.model.LinkFilter;
import com.laivi.crawler.parser.AParser;

public class TimeArticleParser extends AParser {

	public TimeArticleParser(LinkFilter linkFilter,
			LinkFilter parserLinkFilter, String[] seeds) {
		super(linkFilter, parserLinkFilter, seeds);
	}

	@Override
	public <Article> Article parser(String url) {
		return null;
	}

}
