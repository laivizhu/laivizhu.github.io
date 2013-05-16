package com.laivi.sic.model.po.media;

import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.ABasicEntity;

@SuppressWarnings("serial")
@Table("sic_music")
public class Music extends ABasicEntity {
	
	private long albumId;
	
	private String name;
	
	private String path;
	
	private int price;

	public Music() {
	}

	public Music(String name, String path, long albumId) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
