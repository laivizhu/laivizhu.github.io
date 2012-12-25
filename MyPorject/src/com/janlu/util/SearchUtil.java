/**
 * 
 */
package com.janlu.util;

/**
 * @author janlu
 *
 */
public class SearchUtil {
	
	public static boolean binSearch(int[] datas,int num){
		int start=0;
		int end=datas.length;
		int mid=0;
		while(start<=end && !(mid==start && mid==end)){
			mid=(start+end)/2;
			if(datas[mid]==num){
				return true;
			}else if(datas[mid]>num){
				end=mid-1;
			}else{
				start=mid+1;
			}
		}
		
		return false;
	}

}
