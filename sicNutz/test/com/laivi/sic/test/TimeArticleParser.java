package com.laivi.sic.test;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.laivi.crawler.model.LinkFilter;
import com.laivi.crawler.parser.AParser;
import com.laivi.sic.model.po.blog.Article;

public class TimeArticleParser extends AParser {

	public TimeArticleParser(LinkFilter linkFilter,
			LinkFilter parserLinkFilter, String[] seeds) {
		super(linkFilter, parserLinkFilter, seeds);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Article parser(String url) {
		Parser parser=null;
		Article article=new Article();
		article.setUserId(1);
		try {
			parser=new Parser(url);
			parser.setEncoding("utf-8");
			if(url.indexOf("shenghuo")!=-1){
				article.setTagId(6);
			}
			NodeFilter contentFilter=new AndFilter(new TagNameFilter("td"),new HasAttributeFilter("class","neiz1"));
			article.setTitle(getTitle(parser,this.linkFilter));
			parser.reset();
			article.setContent(getContent(contentFilter,parser));
		} catch (ParserException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return article;
	}
	
	public String getTitle(Parser parser,LinkFilter filter){
		String title="";
		try {
			NodeList nodeList = (NodeList) parser.parse(new NodeClassFilter(LinkTag.class));
			for(int i=0;i<nodeList.size();i++){
				LinkTag link=(LinkTag)nodeList.elementAt(i);
				String linkUrl = link.getLink();// url
                if (filter.accept(linkUrl)) {
                	title=link.getStringText();
                	break;
                }
			}
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return title;
	}
	
	public String getContent(NodeFilter filter,Parser parser){
		String content=null;
		try {
			NodeList newsContentList = (NodeList) parser.parse(filter);
			for (int i = 0; i<newsContentList.size();) {
				Node node=newsContentList.elementAt(i);
				content=node.toHtml();
				content=content.substring(content.indexOf("</div>")+6, content.length()-5);
				break;
			}
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return content.toString();
	}

}
