package com.laivi.sic.model.po.media;

import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.ABasicEntity;

@SuppressWarnings("serial")
@Table("sic_picture")
public class Picture extends ABasicEntity {

	private long albumId;
	
	private String description;
	
	private String path;
	
	private String name;
	
	public Picture() {
	}

	public Picture(String name, String path, long albumId) {
		this.name = name;
		this.path = path;
		this.albumId = albumId;
	}

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
