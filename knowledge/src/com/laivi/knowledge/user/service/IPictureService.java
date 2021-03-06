package com.laivi.knowledge.user.service;

import java.io.File;

import net.sf.json.JSONArray;

import com.laivi.knowledge.basic.model.exception.ErrorFileException;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.user.model.po.Picture;

/**
 * User: laivi.zhu@gmail.com
 * Time: 12-11-11 下午1:56
 */
public interface IPictureService extends IBasicService<Picture> {
	JSONArray upload(File[] pictures,String[] picturesFileName,String path,long albumId)throws ErrorFileException;
}
