package com.laivi.sic.model.po.blog;

import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;

@SuppressWarnings("serial")
@Table("sic_knowledge")
public class Knowledge extends AUserEntity {
	
	private String name;
	
	private String question;
	
	private String answer;
	
	private long tagId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	/**
	 * @return the tagId
	 */
	public long getTagId() {
		return tagId;
	}

	/**
	 * @param tagId the tagId to set
	 */
	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

}
