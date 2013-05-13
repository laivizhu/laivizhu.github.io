package com.laivi.sic.model.type;

import com.laivi.sic.model.po.blog.Tag;
import com.laivi.sic.model.po.media.Album;
import com.laivi.sic.model.po.media.Book;
import com.laivi.sic.model.po.media.Chapter;
import com.laivi.sic.model.po.user.User;

public enum IMOType {
	USER("userId",User.class),TAG("tagId",Tag.class),ALBUM("albumId",Album.class),BOOK("bookId",Book.class),CHAPTER("chapterId",Chapter.class);
	
	private final String id;
	private final Class<?> klass;
	
	IMOType(String id,Class<?> klass){
		this.id=id;
		this.klass=klass;
	}
	
	public String getId(){
		return this.id;
	}
	
	public Class<?> getKlass(){
		return this.klass;
	}
	
	public static IMOType fromId(String id){
		for(IMOType type:values()){
			if(type.getId().equals(id)){
				return type;
			}
		}
		return null;
	}
}
