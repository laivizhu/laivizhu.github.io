package com.laivi.sic.model.po.common;

import java.util.Date;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.sic.model.type.Status;

@SuppressWarnings("serial")
@Table("sic_message")
public class Message extends AUserEntity {
	
	private long toUserId;

	@ColDefine(type=ColType.VARCHAR, width=500)
	private String content;
	
	@ColDefine(type=ColType.VARCHAR, width=250)
	private String title;
	
	private Status status=Status.UNREAD;

	public long getToUserId() {
		return toUserId;
	}

	public void setToUserId(long toUserId) {
		this.toUserId = toUserId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Message(long fromUserId, long toUserId, String content, String title) {
		this.userId = fromUserId;
		this.toUserId = toUserId;
		this.content = content;
		this.title = title;
	}

	public Message() {
	}

}
