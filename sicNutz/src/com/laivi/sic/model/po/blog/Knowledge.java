package com.laivi.sic.model.po.blog;

import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.validation.Validations;

@SuppressWarnings("serial")
@Table("sic_knowledge")
public class Knowledge extends AUserEntity {
	
	@Validations(required=true,errorMsg="知识标题不能为空")
	private String title;
	
	@Validations(required=true,errorMsg="知识问题不能为空")
	private String question;
	
	@Validations(required=true,errorMsg="知识答案不能为空")
	private String answer;
	
	private long tagId;
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
