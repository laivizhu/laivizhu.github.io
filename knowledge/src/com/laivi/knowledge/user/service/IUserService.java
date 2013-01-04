package com.laivi.knowledge.user.service;

import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.user.model.po.User;

/**
 * User: laivi.zhu@gmail.com
 * Time: 12-11-11 下午1:55
 */
public interface IUserService extends IBasicService<User> {
    User login(User user)throws ErrorException;
    void register(User user)throws ErrorException;
    void disableOrEnableUser(String userIds)throws ErrorException;
    void resetPassword(String userIds)throws ErrorException;
}
