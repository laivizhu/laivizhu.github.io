package com.laivi.knowledge.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.user.model.po.Album;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午2:08
 */
@Service("AlbumService")
public class AlbumService extends BasicService<Album> implements IAlbumService {
	@Resource(name="AlbumDao")
    public void setBasicDao(IBasicDao<Album> basicDao){
        this.basicDao=basicDao;
    }
	
}
