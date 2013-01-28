package com.laivi.knowledge.user.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.user.model.po.Music;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午1:37
 */
@Service("MusicDao")
public class MusicDao extends ABasicDao<Music> implements IMusicDao {
    public DetachedCriteria getCriteria() {
        return DetachedCriteria.forClass(Music.class);
    }
}
