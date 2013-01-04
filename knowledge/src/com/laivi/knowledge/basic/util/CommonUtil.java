package com.laivi.knowledge.basic.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Janlu
 * Date: 12-12-28
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
public class CommonUtil {
    public static String getI18NMsg(String key){
        return CommonUtil.getI18NMsg(key,Locale.CHINA);
    }

    public static String getI18NMsg(String key,Locale locale){
        return ResourceBundle.getBundle("projectMessage",locale).getString(key);
    }
}

