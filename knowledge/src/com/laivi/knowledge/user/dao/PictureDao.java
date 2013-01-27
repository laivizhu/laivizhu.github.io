package com.laivi.knowledge.user.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.user.model.po.Picture;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午1:37
 */
@Service("PictureDao")
public class PictureDao extends ABasicDao<Picture> implements IPictureDao {
    public DetachedCriteria getCriteria() {
        return DetachedCriteria.forClass(Picture.class);
    }
}
