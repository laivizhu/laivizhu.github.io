package com.laivi.sic.model.po.basic;

@SuppressWarnings("serial")
public abstract class AFavoriteEntity extends AUserEntity {

	protected int favoriteCount;

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	
	
}
