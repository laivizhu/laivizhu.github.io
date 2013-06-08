package com.laivi.sic.model.po.blog;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.validation.Validations;

@SuppressWarnings("serial")
@Table("sic_news")
public class News extends AUserEntity {
	
	@Validations(required=true,errorMsg="新闻题目不能为空")
	@ColDefine(type=ColType.VARCHAR, width=255)
	private String title;
	
	@Validations(required=true,errorMsg="新闻内容不能为空")
	@ColDefine(type=ColType.TEXT)
	private String content;
	
}
