package com.laivi.sic.action.media;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.json.JsonItem;
import com.laivi.sic.model.po.media.BookMark;
import com.laivi.sic.model.po.media.Chapter;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.util.basic.DataUtil;

@IocBean
@At("/media/chapter")
public class ChapterAction extends ABasicDBAction<Chapter> {
	
	@At
	@CheckValue
	public Response add(@Param("::chapter.")Chapter chapter){
		int value=dao.func(Chapter.class, "max", "indexChapter",Cnd.where("bookId", "=", chapter.getBookId()));
		chapter.setIndexChapter(value+1);
		dao.insert(chapter);
		return success();
	}
	
	@At
	@CheckValue
	public Response update(@Param("::chapter.")Chapter chapter){
		Chapter dChapter=dao.fetch(Chapter.class, chapter.getId());
		dChapter.setContent(chapter.getContent());
		dChapter.setTitle(chapter.getTitle());
		dao.update(dChapter);
		return success();
	}
	
	@At
	public Object listChapter(@Param("::page.")Pager page,long id)throws Exception{
		return list(page,Cnd.where("bookId", "=",id));
	}
	
	@At
	public Object getChapter(long id,String dir){
		Chapter chapter=dao.fetch(Chapter.class, id);
		JsonItem item=null;
		String msg=null;
		if(DataUtil.notEmptyString(dir)){
			if("pre".equals(dir)){
				this.cnd=Cnd.where("bookId", "=", chapter.getBookId()).and("indexChapter", "<", chapter.getIndexChapter()).desc("indexChapter");
				msg="已经是第一章了";
			}else{
				this.cnd=Cnd.where("bookId", "=", chapter.getBookId()).and("indexChapter", ">", chapter.getIndexChapter()).asc("indexChapter");
				msg="已经是最后一章了";
			}
			Chapter dirChapter=dao.fetch(Chapter.class, this.cnd);
			if(dirChapter==null){
				return failure(msg);
			}else{
				item=this.getJsonItem(dirChapter, false);
			}
		}
		return item.toJsonForm();
	}
	
	@At
	public Object isAddMark(long id){
		JsonItem item=new JsonItem();
		item.add("isAddMark", dao.count(BookMark.class, Cnd.where("chapterId", "=", id).and("userId", "=", this.getUserId()))>0);
		return item.toJsonForm();
	}

	@Override
	public Class<Chapter> getEntityClass() {
		return Chapter.class;
	}

}
