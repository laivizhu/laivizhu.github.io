package com.laivi.knowledge.user.service;

import java.io.File;

import net.sf.json.JSONArray;

import com.laivi.knowledge.basic.model.exception.ErrorFileException;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.user.model.po.Music;

/**
 * User: laivi.zhu@gmail.com
 * Time: 12-11-11 下午1:56
 */
public interface IMusicService extends IBasicService<Music> {
	JSONArray upload(File[] music,String[] musicsFileName,String path)throws ErrorFileException;
}
