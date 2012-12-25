/**
 * 
 */
package com.janlu.util;

import com.janlu.algorithm.model.stack.ArrayStack;
import com.janlu.algorithm.model.stack.Stack;
import com.janlu.contents.Constants.AlgorithmConstants;
import com.janlu.exception.AlgorithmException;

/**
 * @author janlu
 *
 */
public class DataUtil {
	/**
	 * 
	 * 函数功能说明:十进制转其他进制数
	 * 修改者名字janlu 修改日期  2012-9-12
	 * 修改内容
	 * @参数： @param num
	 * @参数： @param b
	 * @参数： @return
	 * @参数： @throws AlgorithmException    
	 * @return String   
	 * @throws
	 */
	public static String convert(int num,int b) throws AlgorithmException{
		Stack<Integer> stack=new ArrayStack<Integer>();
		while(num!=0){
			stack.push(num%b);
			num=num/b;
		}
		int maxcount=stack.getCurrentCount();
		if(maxcount==0){
			return "0";
		}else{
			StringBuilder result=new StringBuilder();
			for(int i=0;i<maxcount;i++){
				result.append(renderResult(stack.pop(),b));
			}
			return result.toString();
		}
	}
	/**
	 * 
	 * 函数功能说明:将十六进制中的10到15表示成相应的字符
	 * 修改者名字janlu 修改日期  2012-9-12
	 * 修改内容
	 * @参数： @param num
	 * @参数： @param b
	 * @参数： @return    
	 * @return String   
	 * @throws
	 */
	private static String renderResult(int num,int b){
		String result=null;
		if(b==16){
			char[] character={'A','B','C','D','E','F'};
			for(int i=0;i<character.length;i++){
				if(num==(i+10)){
					result= character[i]+AlgorithmConstants.EMPTY;
					break;
				}
			}
		}
		return  ParamAssert.nullValue(result,num+AlgorithmConstants.EMPTY);
	}
}
