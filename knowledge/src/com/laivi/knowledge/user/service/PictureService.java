package com.laivi.knowledge.user.service;

import java.io.File;
import java.util.Date;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.model.exception.ErrorFileException;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.basic.util.DataUtil;
import com.laivi.knowledge.basic.util.FileUtil;
import com.laivi.knowledge.user.dao.IAlbumDao;
import com.laivi.knowledge.user.model.po.Album;
import com.laivi.knowledge.user.model.po.Picture;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午1:55
 */
@Service("PictureService")
public class PictureService extends BasicService<Picture> implements IPictureService {

	private IAlbumDao albumDao;
	
    @Resource(name="PictureDao")
    public void setBasicDao(IBasicDao<Picture> basicDao){
        this.basicDao=basicDao;
    }
    
    @Resource(name="AlbumDao")
	public void setAlbumDao(IAlbumDao albumDao) {
		this.albumDao = albumDao;
	}

	@Override
	public JSONArray upload(File[] pictures, String[] picturesFileName,String path,long albumId) throws ErrorFileException {
		Album album=albumDao.getObject(albumId);
		StringBuilder sb=new StringBuilder();
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<pictures.length;i++){
			try {
				Picture picture=new Picture(picturesFileName[i].substring(0, picturesFileName[i].indexOf(".")),FileUtil.saveCodingFile(pictures[i], path, picturesFileName[i]),new Date());
				this.add(picture);
				JSONObject jsono = new JSONObject();
				jsono.put("id", picture.getId());
				jsono.put("name", picturesFileName[i]);
				jsono.put("size",pictures[i].length());
				jsono.put("url", "picture_downLoad.action?fileName="+picturesFileName[i]);
				jsono.put("delete_url","picture_delete.action?id="+picture.getId()+"&fileName="+picture.getPath());
				jsono.put("delete_type","GET");
				jsonArray.add(jsono);
				if(i!=pictures.length-1){
					sb.append(picture.getId()+",");
				}else{
					sb.append(picture.getId());
				}
			} catch (Exception e) {
				throw new ErrorFileException("");
			}
		}
		if(DataUtil.notEmptyString(album.getItemIds())){
			album.setItemIds(album.getItemIds()+","+sb.toString());
		}else{
			album.setItemIds(sb.toString());
		}
		albumDao.modify(album);
		return jsonArray;
	}
    
}
