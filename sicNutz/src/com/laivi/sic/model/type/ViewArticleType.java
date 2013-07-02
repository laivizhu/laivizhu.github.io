package com.laivi.sic.model.type;

public enum ViewArticleType {
	HOT("SELECT a.*,count(*) replyCount from sic_article a LEFT OUTER JOIN sic_reply r on a.id=r.objId and r.type='ARTICLE' and a.auth='PUBLIC' GROUP BY a.id ORDER BY replyCount desc,viewCount desc,createDate desc"),
	RANDOM("select a.* from sic_article a where auth='PUBLIC' order by rand()"),
	HIGHT("SELECT a.*,AVG(r.score) replyScore from sic_article a LEFT OUTER JOIN sic_ratescore r on a.id=r.objectId and r.type='ARTICLE' and a.auth='PUBLIC' GROUP BY a.id ORDER BY replyScore desc,viewCount desc,createDate desc"),
	NEW("select a.* from sic_article a where deleteIs=0 and auth='PUBLIC' order by createDate desc"),
	RECOMMON("select a.* from sic_article a,sic_recommond r where a.id=r.objId and r.type='ARTICLE' and a.auth='PUBLIC' order by r.createDate desc");
	
	private final String sql;
	
	ViewArticleType(String sql){
		this.sql=sql;
	}
	
	public String toSql(){
		return this.sql;
	}
}
