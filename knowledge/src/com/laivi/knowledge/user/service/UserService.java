package com.laivi.knowledge.user.service;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.model.CriterionList;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.basic.util.DataUtil;
import com.laivi.knowledge.user.model.po.User;

/**
 * @author Administrator
 *
 */
@Service("UserService")
public class UserService extends BasicService<User> implements IUserService {

    @Resource(name="UserDao")
     public void setBasicDao(IBasicDao<User> basicDao){
        this.basicDao=basicDao;
    }

    public User login(User user) throws ErrorException {
        CriterionList conditions=CriterionList.CreateCriterion()
                .put(Restrictions.eq("account", user.getAccount()));
        User dUser=this.getObject(conditions);
        if(dUser==null){
            throw new ErrorException("error.user.login.user.notExist");
        }else{
            if(dUser.isEnable()){
                if(!dUser.getPassword().equals(user.getPassword())){
                    throw new ErrorException("error.user.login.user.passwordError");
                }else{
                    return dUser;
                }
            } else{
                throw new ErrorException("error.user.login.user.isNotEnable");
            }

        }
    }

    public void register(User user) throws ErrorException {
        CriterionList conditions=CriterionList.CreateCriterion()
                .put(Restrictions.eq("account", user.getAccount()));
        if(this.getCount(conditions)>0){
            throw new ErrorException("error.user.register.user.hasExist");
        }else{
            try {
                this.add(user);
            } catch (Exception e) {
                throw new ErrorException("error.add.failure");
            }
        }
    }

	@Override
	public void disableOrEnableUser(String userIds) throws ErrorException {
		for(long id:DataUtil.changeIdString(userIds)){
			User user;
			try {
				user = this.getObject(id);
				user.setEnable(!user.isEnable());
				this.modify(user);
			} catch (Exception e) {
				throw new ErrorException("error.object.notExist");
			}
		}
	}

	@Override
	public void resetPassword(String userIds) throws ErrorException {
		for(long id:DataUtil.changeIdString(userIds)){
			User user;
			try {
				user = this.getObject(id);
				if(user.isReset()){
					user.setPassword("8888");
					user.setReset(false);
					this.modify(user);
				}
			} catch (Exception e) {
				throw new ErrorException("error.object.notExist");
			}
		}
	}
}
