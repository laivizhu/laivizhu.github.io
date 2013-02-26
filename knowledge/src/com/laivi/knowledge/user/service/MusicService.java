package com.laivi.knowledge.user.service;

import java.io.File;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.model.exception.ErrorFileException;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.basic.util.FileUtil;
import com.laivi.knowledge.user.model.po.Music;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午1:55
 */
@Service("MusicService")
public class MusicService extends BasicService<Music> implements IMusicService {

    @Resource(name="MusicDao")
    public void setBasicDao(IBasicDao<Music> basicDao){
        this.basicDao=basicDao;
    }

	@Override
	public JSONArray upload(File[] musics, String[] musicsFileName,String path,long albumId) throws ErrorFileException {
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<musics.length;i++){
			try {
				Music music=new Music(musicsFileName[i].substring(0, musicsFileName[i].indexOf(".")),FileUtil.saveCodingFile(musics[i], path, musicsFileName[i]),albumId);
				this.add(music);
				JSONObject jsono = new JSONObject();
				jsono.put("id", music.getId());
				jsono.put("name", musicsFileName[i]);
				jsono.put("size",musics[i].length());
				jsono.put("url", "music_downLoad.action?fileName="+musicsFileName[i]);
				jsono.put("delete_url","music_delete.action?id="+music.getId()+"&fileName="+music.getPath());
				jsono.put("delete_type","GET");
				jsonArray.add(jsono);
			} catch (Exception e) {
				throw new ErrorFileException("");
			}
		}
		return jsonArray;
	}
    
}
