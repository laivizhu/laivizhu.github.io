package com.laivi.knowledge.user.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.action.ABasicAction;
import com.laivi.knowledge.basic.model.CriterionList;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonItemList;
import com.laivi.knowledge.basic.service.IBasicService;
import com.laivi.knowledge.basic.util.ParamAssert;
import com.laivi.knowledge.user.model.po.Role;
import com.laivi.knowledge.user.model.po.User;
import com.laivi.knowledge.user.service.IRoleService;
import com.laivi.knowledge.user.service.IUserService;

/**
 * 用户情况处理
 *
 * @author Administrator
 */
@SuppressWarnings("serial")
public class UserAction extends ABasicAction<User> {
    private IUserService userService;
    private IRoleService roleService;
    private User user;
    
    private String confirmPassword;

    public String login()throws Exception{
       ParamAssert.isNotEmptyString(user.getAccount(),"error.user.login.account.notNULL");
       ParamAssert.isNotEmptyString(user.getPassword(),"error.user.login.password.notNULL");
       user=userService.login(user);
       ServletActionContext.getRequest().getSession().setAttribute("user", user);
       return response(true);
    }
    
    public String loginAdmin()throws Exception{
        ParamAssert.isNotEmptyString(user.getAccount(),"error.user.login.account.notNULL");
        ParamAssert.isNotEmptyString(user.getPassword(),"error.user.login.password.notNULL");
        user=userService.login(user);
        if(!user.isSysUser()){
        	throw new ErrorException("后台,只能管理员登入",true);
        }
        ServletActionContext.getRequest().getSession().setAttribute("user", user);
        return response(true);
     }
    
    public String logout()throws Exception{
    	ServletActionContext.getRequest().getSession().removeAttribute("user");
    	if(fold){
    		return response(true);
    	}else{
    		return "logout";
    	}
    }

    public String add()throws Exception{
        ParamAssert.isNotEmptyString(user.getAccount(),"error.user.login.account.notNULL");
        ParamAssert.isNotEmptyString(user.getPassword(),"error.user.login.password.notNULL");
        ParamAssert.isNotEmptyString(user.getUserName(),"error.user.login.userName.notNULL");
        ParamAssert.isNotEmptyString(confirmPassword,"error.user.register.user.confirmpassword.notNULL");
        ParamAssert.isTrue(confirmPassword.equals(user.getPassword()),"error.user.register.user.password.notSample");
        userService.register(user);
        return response(true);
    }

    public String update()throws Exception{
        ParamAssert.isNotEmptyString(user.getUserName(),"error.user.login.userName.notNULL");
        ParamAssert.isTrue(id!=0,this.getText("error.object.notExist"));
        User dUser=userService.getObject(id);
        dUser.setUserName(user.getUserName());
        userService.modify(dUser);
        return response(true);
    }
    
    public String resetPassword()throws Exception{
    	ParamAssert.isNotEmptyString(ids, "error.object.notChoose");
    	userService.resetPassword(ids);
    	return response(true);
    }
    
    public String disableOrEnableUser()throws Exception{
    	ParamAssert.isNotEmptyString(ids, "error.objcet.notChoose");
    	userService.disableOrEnableUser(ids);
    	return response(true);
    }

    public String list()throws Exception{
    	return response(list(true,false));
    }
    
    public String search()throws Exception{
    	this.getSearchConditions();
    	return response(list(!notBreakPage,false));
    }
    
    public String roleList()throws Exception{
        JsonItemList jsonList=new JsonItemList();
        CriterionList conditions=CriterionList.CreateCriterion().put(Restrictions.ne("name", "ROLE_ADMIN"));
        for(Role role:roleService.getList(conditions)){
            jsonList.createItem().add("text",role.getDescription()).add("value",role.getId());
        }
        return response(jsonList);
    }

    public JsonItem getJsonItem(User object,boolean isSub) throws Exception {
        JsonItem jsonItem=new JsonItem();
        jsonItem.add("id",object.getId())
                .add("account",object.getAccount())
                .add("userName",object.getUserName())
                .add("enable", object.isEnable())
                .add("reset", object.isReset())
                .add("description",object.getDescription());
        return jsonItem;
    }
    
    public JsonItemList getSearchComboList()throws ErrorException{
		JsonItemList jsonList=new JsonItemList();
		return jsonList;
	}

    @Resource(name = "UserService")
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
    @Resource(name = "RoleService")
    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }
    @Resource(name = "UserService")
    public void setBasicService(IBasicService<User> basicService){
    	this.basicService=basicService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
