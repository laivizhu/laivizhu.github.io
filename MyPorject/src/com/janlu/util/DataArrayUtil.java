/**
 * 
 */
package com.janlu.util;

import java.util.Random;

import com.janlu.contents.Constants.AlgorithmConstants;

/**
 * @author janlu
 *
 */
public class DataArrayUtil {
	
	/**
	 * 
	 * ��������˵��:��ȡһ�������
	 * �޸�������janlu �޸�����  2012-9-12
	 * �޸�����
	 * @������ @param datas
	 * @������ @param isRepeat���������Ƿ��ظ�    
	 * @return void   
	 * @throws
	 */
	public static int[] getRandomArray(int size,boolean isRepeat){
		int[] datas=new int[size];
		Random rand=new Random();
		if(isRepeat){
			for(int i=0;i<size;i++){
				datas[i]=rand.nextInt(size-1);
			}
		}else{
			for(int i=0;i<size;i++){
				datas[i]=i;
			}
			for(int i=0;i<size/2;i++){
				int n=rand.nextInt(size-1);
				while(n==i){
					n=rand.nextInt(size-1);
				}
				int temp=datas[i];
				datas[i]=datas[n];
				datas[n]=temp;
			}
		}
		return datas;
	}
	
	
	/**
	 * 
	 * ��������˵��:��Integer����ת��Ϊint����
	 * �޸�������janlu �޸�����  2012-9-12
	 * �޸�����
	 * @������ @param src
	 * @������ @return    
	 * @return int[]   
	 * @throws
	 */
	public static int[] IntegerToInt(Integer[] src){
		int[] dst=new int[src.length];
		int i=0;
		for(Integer integer:src){
			dst[i++]=integer;
		}
		return dst;
	}
	
	/**
	 * 
	 * ��������˵��:�������鵽һ���µ�����,������
	 * �޸�������janlu �޸�����  2012-9-12
	 * �޸�����
	 * @������ @param srcArray
	 * @������ @return    
	 * @return int[]   
	 * @throws
	 */
	public static int[] copyArray(int[] srcArray){
		int[] dst=new int[srcArray.length];
		int i=0;
		for(int num:srcArray){
			dst[i++]=num;
		}
		return dst;
	}
	
	public static String toString(int[] objects){
		return toString(objects,objects.length);
	}
	
	/**
	 * 
	 * ��������˵��:�����������
	 * �޸�������janlu �޸�����  2012-9-12
	 * �޸�����
	 * @������ @param objects
	 * @������ @param size
	 * @������ @return    
	 * @return String   
	 * @throws
	 */
	public static String toString(int[] objects,int size){
		StringBuilder sb=new StringBuilder(AlgorithmConstants.EMPTY);
		int i=0;
		for(int object:objects){
			if(i>=size){
				break;
			}
			sb.append(object+AlgorithmConstants.Symbol.Comma);
			i++;
		}
		if(AlgorithmConstants.EMPTY.equals(sb.toString())){
			return AlgorithmConstants.EMPTY;
		}else{
			return sb.toString().substring(0, sb.toString().length()-1);
		}
	}
	
	/**
	 * 
	 * ��������˵��:���������е�����λ��
	 * �޸�������janlu �޸�����  2012-9-10
	 * �޸�����
	 * @������ @param datas
	 * @������ @param i
	 * @������ @param j    
	 * @return void   
	 * @throws
	 */
	public static void swap(int[] datas,int i,int j){
		/*datas[i]=datas[i]^datas[j];
		datas[j]=datas[i]^datas[j];
		datas[i]=datas[i]^datas[j];*/
		int temp=datas[i];
		datas[i]=datas[j];
		datas[j]=temp;
	}

}
