package com.laivi.sic.model.type;

import com.laivi.sic.model.po.blog.Article;
import com.laivi.sic.model.po.blog.Knowledge;
import com.laivi.sic.model.po.media.Album;
import com.laivi.sic.model.po.media.Book;
import com.laivi.sic.model.po.media.Music;
import com.laivi.sic.model.po.media.Picture;
import com.laivi.sic.model.po.system.News;

public enum CategoryType {
	NEWS("新闻",News.class),
	ARTICLE("文章",Article.class),
	KNOWLEDGE("知识",Knowledge.class),
	PICTURE("图片",Picture.class),
	MUSIC("音乐",Music.class),
	BOOK("书籍",Book.class),
	ALBUM("相册",Album.class);
	
	private final String text;
	
	private final Class<?> klass;
	
	CategoryType(String text,Class<?> klass){
		this.text=text;
		this.klass=klass;
	}
	
	public String toText(){
		return this.text;
	}
	
	public Class<?> toclass(){
		return this.klass;
	}
}
