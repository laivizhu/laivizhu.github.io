package com.laivi.crawler.parser;

import com.laivi.crawler.model.LinkFilter;

public abstract class AParser implements Parsers {

	protected LinkFilter linkFilter;
	
	protected LinkFilter parserLinkFilter;
	
	protected String[] seeds;
	
	
	public AParser(LinkFilter linkFilter, LinkFilter parserLinkFilter,
			String[] seeds) {
		this.linkFilter = linkFilter;
		this.parserLinkFilter = parserLinkFilter;
		this.seeds = seeds;
	}

	@Override
	public LinkFilter getLinkFilter() {
		return this.linkFilter;
	}

	@Override
	public String[] getSeeds() {
		return this.seeds;
	}

	@Override
	public LinkFilter getParserLinkFilter() {
		return this.parserLinkFilter;
	}
	
	
}
