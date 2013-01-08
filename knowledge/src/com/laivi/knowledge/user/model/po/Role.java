package com.laivi.knowledge.user.model.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.laivi.knowledge.basic.model.po.BasicEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.laivi.knowledge.basic.model.po.BaseEntity;


@SuppressWarnings("serial")
@Entity
@Table(name = "t_role")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Role extends BasicEntity implements BaseEntity {
	private long id;
	private String name;
	private String description;

    public  Role(){};

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
