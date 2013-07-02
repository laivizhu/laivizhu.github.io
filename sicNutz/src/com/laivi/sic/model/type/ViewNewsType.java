package com.laivi.sic.model.type;

public enum ViewNewsType {
	HOT("SELECT a.*,count(*) replyCount from sic_news a LEFT OUTER JOIN sic_reply r on a.id=r.objId and r.type='NEWS' GROUP BY a.id ORDER BY replyCount desc,viewCount desc,createDate desc"),
	RANDOM("select a.* from sic_news a order by rand()"),
	NEW("select a.* from sic_news a where deleteIs=0  order by createDate desc"),
	RECOMMON("select a.* from sic_news a,sic_recommond r where a.id=r.objId and r.type='NEWS' order by r.createDate desc");
	
	private final String sql;
	
	ViewNewsType(String sql){
		this.sql=sql;
	}
	
	public String toSql(){
		return this.sql;
	}
}
