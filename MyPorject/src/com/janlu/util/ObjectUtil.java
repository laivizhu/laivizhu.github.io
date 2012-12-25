/**
 * 
 */
package com.janlu.util;

import com.janlu.contents.Constants;
import com.janlu.contents.Constants.AlgorithmConstants;
import com.janlu.exception.AlgorithmException;

/**
 * @author janlu
 *
 */
public class ObjectUtil {
	
	/**
	 * 
	 * 函数功能说明:对象以第n个位置进行翻转（）
	 * 修改者名字janlu 修改日期  2012-9-3
	 * 修改内容
	 * @参数： @param objects
	 * @参数： @param n    
	 * @return void   
	 * @throws
	 */
	public static void turn(Object[] objects,int n){
		reverse(objects,0,n-1);
		reverse(objects,n,objects.length-1);
		reverse(objects,0,objects.length-1);
	}
	
	/**
	 * 
	 * 函数功能说明：对象中从start到end求逆
	 * 修改者名字janlu 修改日期  2012-9-3
	 * 修改内容
	 * @参数： @param objects
	 * @参数： @param start
	 * @参数： @param end    
	 * @return void   
	 * @throws
	 */
	public static void reverse(Object[] objects,int start,int end){
		if(start>=0 && start <=end && end<objects.length){
			while(start<=end){
				Object temp=objects[start];
				objects[start]=objects[end];
				objects[end]=temp;
				start++;
				end--;
			}
		}
	}
	
	public static String toString(Object[] objects){
		return toString(objects,objects.length);
	}
	
	public static String toString(Object obj){
		return obj==null?Constants.AlgorithmConstants.EMPTY:obj.toString();
	}
	
	/**
	 * 
	 * 函数功能说明:将数组对象转换为字符输出
	 * 修改者名字janlu 修改日期  2012-9-12
	 * 修改内容
	 * @参数： @param objects
	 * @参数： @param size
	 * @参数： @return    
	 * @return String   
	 * @throws
	 */
	public static String toString(Object[] objects,int size){
		StringBuilder sb=new StringBuilder(AlgorithmConstants.EMPTY);
		int i=0;
		for(Object object:objects){
			if(i>=size){
				break;
			}
			sb.append(object.toString()+AlgorithmConstants.Symbol.Comma);
			i++;
		}
		return sb.toString().substring(0, sb.toString().length()-1);
	}
	
	/**
	 * 
	 * 函数功能说明：复制数组对象
	 * 修改者名字janlu 修改日期  2012-9-12
	 * 修改内容
	 * @参数： @param srcArray
	 * @参数： @param dstArray
	 * @参数： @throws AlgorithmException    
	 * @return void   
	 * @throws
	 */
	public static void copyArray(Object[] srcArray,Object[] dstArray) throws AlgorithmException{
		ParamAssert.isTrue(srcArray.length>dstArray.length, AlgorithmConstants.Error.ArrayOutError);
		int i=0;
		for(Object object:srcArray){
			dstArray[i++]=object;
		}
	}
	
	public static void copyArray(int[][] srcArray,int[][] dstArray){
		for(int i=0;i<srcArray.length;i++){
			for(int j=0;j<srcArray[i].length;j++){
				dstArray[i][j]=srcArray[i][j];
			}
		}
	}
	
	public static boolean equalArray(int[][] src,int[][] dst){
		for(int i=0;i<src.length;i++){
			for(int j=0;j<src[i].length;j++){
				if(src[i][j]!=dst[i][j]){
					return false;
				}
			}
		}
		return true;
	}
	
	public static String outArray(int[][] array){
		StringBuilder sb=new StringBuilder("{");
		for(int i=0;i<array.length;i++){
			sb.append("[");
			for(int j=0;j<array[i].length;j++){
				sb.append(array[i][j]);
				if(j!=array[i].length-1){
					sb.append(",");
				}
				
			}
			sb.append("]");
			if(i!=array.length-1){
				sb.append(",");
			}
		}
		sb.append("}");
		return sb.toString();
	}
}
