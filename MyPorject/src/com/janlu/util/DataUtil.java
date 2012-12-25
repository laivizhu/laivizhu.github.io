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
	 * ��������˵��:ʮ����ת����������
	 * �޸�������janlu �޸�����  2012-9-12
	 * �޸�����
	 * @������ @param num
	 * @������ @param b
	 * @������ @return
	 * @������ @throws AlgorithmException    
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
	 * ��������˵��:��ʮ�������е�10��15��ʾ����Ӧ���ַ�
	 * �޸�������janlu �޸�����  2012-9-12
	 * �޸�����
	 * @������ @param num
	 * @������ @param b
	 * @������ @return    
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
