/**
 * 
 */
package com.janlu.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author janlu
 *
 */
public class OtherUtil {
	
	public static Map<String,List<String>> squash(String[] directory){
		return squash(Arrays.asList(directory));
	}
	
	public static Map<String,List<String>> squash(List<String> directory){
		Map<String,List<String>> words=new HashMap<String,List<String>>();
		for(String word:directory){
			String temp=SortUtil.sortString(word);
			if(words.get(temp)==null){
				List<String> tempList=new ArrayList<String>();
				tempList.add(word);
				words.put(temp,tempList);
			}else{
				words.get(temp).add(word);
			}
		}
		return words;
	}
	
	public static String getPhoneNumberFromString(String name){
		char[] phones=new char[name.length()];
		int i=0;
		for(char a:name.toCharArray()){
			char la=Character.toLowerCase(a);
			phones[i++]=getPhoneNumber(Character.toString(la));
		}
		return phones.toString();
	}
	
	public static char getPhoneNumber(String a){
		String[] chars={"abc","def","ghi","jkl","mno","prs","tuv","wxy"};
		char[] numbers={'2','3','4','5','6','7','8','9'};
		for(int i=0;i<=7;i++){
			if(a.indexOf(chars[i])!=-1){
				return numbers[i];
			}
		}
		return '*';
	}

}
