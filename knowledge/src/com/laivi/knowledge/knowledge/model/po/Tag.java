package com.laivi.knowledge.knowledge.model.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.po.BasicEntity;
import com.laivi.knowledge.basic.model.type.TagType;
import com.laivi.knowledge.basic.util.DateUtil;

@SuppressWarnings("serial")
@Entity
@Table(name="t_tag")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Tag extends BasicEntity{
    private long id;

    private String name;
    
    private long userId;
    
    private TagType type;
    
    private Date createDate=new Date();

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
