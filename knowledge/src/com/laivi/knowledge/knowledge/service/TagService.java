package com.laivi.knowledge.knowledge.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.model.constants.AppConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.basic.util.DataUtil;
import com.laivi.knowledge.knowledge.model.po.Tag;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午1:55
 */
@Service("TagService")
public class TagService extends BasicService<Tag> implements ITagService {

    @Resource(name="TagDao")
    public void setBasicDao(IBasicDao<Tag> basicDao){
        this.basicDao=basicDao;
    }

	@Override
	public String getTagsName(String idStrings) throws ErrorException {
		if(DataUtil.notEmptyString(idStrings)){
			StringBuilder sb=new StringBuilder();
			for(Tag tag:this.getList(idStrings)){
				sb.append(tag.getName()+",");
			}
			return sb.toString().substring(0, sb.toString().length()-1);
		}else{
			return AppConstants.EMPTY;
		}
	}
    
}
