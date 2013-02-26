package com.laivi.knowledge.common.service;

import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.common.model.po.Tag;

/**
 * User: laivi.zhu@gmail.com
 * Time: 12-11-11 下午1:56
 */
public interface ITagService extends IBasicService<Tag> {
	String getTagsName(String idStrings)throws ErrorException;
}
