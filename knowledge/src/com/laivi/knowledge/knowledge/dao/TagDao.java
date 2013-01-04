package com.laivi.knowledge.knowledge.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.knowledge.model.po.Tag;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午1:37
 */
@Service("TagDao")
public class TagDao extends ABasicDao<Tag> implements ITagDao {
    public DetachedCriteria getCriteria() {
        return DetachedCriteria.forClass(Tag.class);
    }
}
