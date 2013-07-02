package com.laivi.sic.util.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLUtil {

	public static String getImageUrl(String content){
		Pattern p=Pattern.compile("<img.*?src.*?=.*?\".*?\".*?/>");
		Matcher ma=p.matcher(content);
		if(ma.find()){
			String img= ma.group();
			p=Pattern.compile("http://.*?\"");
			ma=p.matcher(img);
			if(ma.find()){
				String url=ma.group();
				return url.substring(0, url.length()-1);
			}
		}
		return null;
	}
	
	public static String getVedioUrl(String content){
		Pattern p=Pattern.compile("<embed.*?src.*?=.*?\".*?\".*?/>");
		Matcher ma=p.matcher(content);
		if(ma.find()){
			String vedio= ma.group();
			p=Pattern.compile("http://.*?\"");
			ma=p.matcher(vedio);
			if(ma.find()){
				String url=ma.group();
				return url.substring(0, url.length()-1);
			}
		}
		return null;
	}
}
