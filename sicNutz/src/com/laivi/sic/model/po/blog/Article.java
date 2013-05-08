package com.laivi.sic.model.po.blog;

import java.lang.reflect.Field;

import org.nutz.dao.entity.annotation.Table;
import org.nutz.validation.annotation.Validations;

import com.laivi.sic.model.exception.ErrorException;
import com.laivi.sic.model.json.JsonItem;
import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.sic.util.basic.DataUtil;

@SuppressWarnings("serial")
@Table("sic_article")
public class Article extends AUserEntity {
	
	@Validations(required=true,errorMsg="文章题目不能为空")
	private String title;
	
	@Validations(required=true,errorMsg="文章内容不能为空")
	private String content;
	
	private long viewCount;
	
	private long tagId;
	
	private boolean otherIs;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getViewCount() {
		return viewCount;
	}

	public void setViewCount(long viewCount) {
		this.viewCount = viewCount;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getTagId() {
		return tagId;
	}
	
	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	public boolean isOtherIs() {
		return otherIs;
	}

	public void setOtherIs(boolean otherIs) {
		this.otherIs = otherIs;
	}

	@Override
	public JsonItem toJsonItem(boolean fold) {
		JsonItem item=new JsonItem();
		Field[] fields=DataUtil.appendArray(Article.class.getSuperclass().getDeclaredFields(), Article.class.getSuperclass().getSuperclass().getDeclaredFields());
		for(Field field:DataUtil.appendArray(Article.class.getDeclaredFields(), fields)){
			try {
				if(fold &&"content".equals(field.getName())){
					item.add(field.getName(),DataUtil.getDefaultChar((String)field.get(this)));
				}else{
					item.add(field.getName(),field.get(this));
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ErrorException e) {
				e.printStackTrace();
			}
		}
		return item;
	}
}
