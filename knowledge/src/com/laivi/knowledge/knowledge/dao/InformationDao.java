package com.laivi.knowledge.knowledge.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.knowledge.model.po.Information;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午1:37
 */
@Service("InformationDao")
public class InformationDao extends ABasicDao<Information> implements IInformationDao {
    public DetachedCriteria getCriteria() {
        return DetachedCriteria.forClass(Information.class);
    }
}
