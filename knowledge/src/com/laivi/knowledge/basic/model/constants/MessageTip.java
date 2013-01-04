package com.laivi.knowledge.basic.model.constants;

/**
 * Created by IntelliJ IDEA.
 * User: Janlu
 * Date: 12-11-5
 * Time: 下午5:47
 * To change this template use File | Settings | File Templates.
 */
public interface MessageTip {
    interface Common{
        String LODING="加载" ;
        String SUCCESS="成功";
        String FAILURE="失败";
    }
    interface UserManage{
        String REGISTER="注册";
        String DELETE="删除";
        String UPDATE="修改";
        String ADD="添加";
        String VERIFY="认证";
        String UPDATE_PASSWORD="修改密码";
        String DISABLED_OR_ENABLED="禁用或启用";
        String RESET_PASSWORD="重置";
    }
}
