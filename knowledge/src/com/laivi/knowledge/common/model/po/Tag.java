package com.laivi.knowledge.common.model.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.po.UserEntity;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.knowledge.model.type.TagType;

@SuppressWarnings("serial")
@Entity
@Table(name="t_tag")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Tag extends UserEntity{
    private long id;

    private String name;
    
    private long userId;
    
    private TagType type;
    
    private Date createDate=new Date();

    public Tag() {
    }

    public Tag(String name, long userId, TagType type) {
        this.name = name;
        this.userId = userId;
        this.type = type;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public TagType getType() {
		return type;
	}

	public void setType(TagType type) {
		this.type = type;
	}

	@Override
	public String toJson() {
		JsonItem item=new JsonItem();
    	item.add("id", this.getId())
    	.add("name", this.getName())
    	.add("type", this.getType().toText())
    	.add("createDate", DateUtil.formatDate(this.getCreateDate()));
		return item.toString();
	}
	
}
