package com.laivi.sic.action.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.expressme.openid.Association;
import org.expressme.openid.Authentication;
import org.expressme.openid.Endpoint;
import org.expressme.openid.OpenIdException;
import org.expressme.openid.OpenIdManager;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import com.laivi.sic.action.basic.ABasicAction;
import com.laivi.sic.model.po.user.LoginUser;
import com.laivi.sic.model.po.user.NonceInfo;
import com.laivi.sic.util.basic.DataUtil;

@IocBean
@At("/auth/jopenid")
public class JOpenIDAuth extends ABasicAction{

    static final long ONE_HOUR = 3600000L;
    static final long TWO_HOUR = ONE_HOUR * 2L;
    static final String ATTR_MAC = "openid_mac";
    static final String ATTR_ALIAS = "openid_alias";
	
    @Inject
	private Dao dao;
	
	private String enpoint;
	
	private OpenIdManager manager = new OpenIdManager();
	
	@At
	@Ok(">>:${obj}")
	public String login(HttpSession session) {
		Endpoint endpoint = manager.lookupEndpoint(enpoint);
        Association association = manager.lookupAssociation(endpoint);
        session.setAttribute(ATTR_MAC, association.getRawMacKey());
        session.setAttribute(ATTR_ALIAS, endpoint.getAlias());
        return manager.getAuthenticationUrl(endpoint, association);
	}
	
	@At
	@Ok("void")
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	@At
	@Ok("->:/WEB-INF/auth/me.ftl")
	public Object me(HttpSession session) {
		return session.getAttribute(LoginUser.class.getName());
	}
	
	@Ok(">>:/")
	@At
	public Object returnPoint(HttpServletRequest request) {
		checkNonce(request.getParameter("openid.response_nonce"));
        // get authentication:
        byte[] mac_key = (byte[]) request.getSession().getAttribute(ATTR_MAC);
        String alias = (String) request.getSession().getAttribute(ATTR_ALIAS);
        Authentication authentication = manager.getAuthentication(request, mac_key, alias);
        String identity = authentication.getIdentity();
        LoginUser authUserInfo = dao.fetch(LoginUser.class, identity);
        if (authUserInfo == null) {
        	authUserInfo = new LoginUser();
        	authUserInfo.setUidendity(identity);
        	authUserInfo.setEmail(authentication.getEmail());
        	authUserInfo.setPassword(DataUtil.getRandPassword());
        	dao.insert(authUserInfo);
        	authUserInfo = dao.fetch(LoginUser.class, identity);
        }
        request.getSession().setAttribute(LoginUser.class.getName(), authUserInfo);
        return authUserInfo;
	}
	
    private void checkNonce(String nonce) {
        // check response_nonce to prevent replay-attack:
        if (nonce==null || nonce.length()<20)
            throw new OpenIdException("Verify failed.");
        long nonceTime = getNonceTime(nonce);
        long diff = System.currentTimeMillis() - nonceTime;
        if (diff < 0)
            diff = (-diff);
        if (diff > ONE_HOUR)
            throw new OpenIdException("Bad nonce time.");
        if (isNonceExist(nonce))
            throw new OpenIdException("Verify nonce failed.");
        storeNonce(nonce, nonceTime + TWO_HOUR);
    }

    private boolean isNonceExist(String nonce) {
    	Cnd cnd = Cnd.where("nonce", "=", nonce);
    	return null != dao.fetch(NonceInfo.class, cnd);
    }

    private void storeNonce(String nonce, long expires) {
    	NonceInfo nonceInfo = new NonceInfo();
    	nonceInfo.setNonce(nonce);
    	nonceInfo.setExpireTime(expires);
    	dao.insert(nonceInfo);
    }
	
    private static long getNonceTime(String nonce) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .parse(nonce.substring(0, 19) + "+0000")
                    .getTime();
        }
        catch(ParseException e) {
            throw new OpenIdException("Bad nonce time.");
        }
    }
	
	@Inject
	public void setAuthConfig(Map<String,String> authConfig){
		manager.setReturnTo(authConfig.get("returnURL"));
		manager.setRealm(authConfig.get("realm"));
		enpoint = authConfig.get("enpoint");
		if (enpoint == null)
			enpoint = "Google";
	}

}
