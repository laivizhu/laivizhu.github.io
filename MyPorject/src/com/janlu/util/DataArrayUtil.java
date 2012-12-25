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
	 * 函数功能说明:获取一组随机数
	 * 修改者名字janlu 修改日期  2012-9-12
	 * 修改内容
	 * @参数： @param datas
	 * @参数： @param isRepeat：数组中是否重复    
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
	 * 函数功能说明:将Integer数组转换为int数组
	 * 修改者名字janlu 修改日期  2012-9-12
	 * 修改内容
	 * @参数： @param src
	 * @参数： @return    
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
	 * 函数功能说明:复制数组到一个新的数组,并返回
	 * 修改者名字janlu 修改日期  2012-9-12
	 * 修改内容
	 * @参数： @param srcArray
	 * @参数： @return    
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
	 * 函数功能说明:整型数组输出
	 * 修改者名字janlu 修改日期  2012-9-12
	 * 修改内容
	 * @参数： @param objects
	 * @参数： @param size
	 * @参数： @return    
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
	 * 函数功能说明:交换数组中的两个位置
	 * 修改者名字janlu 修改日期  2012-9-10
	 * 修改内容
	 * @参数： @param datas
	 * @参数： @param i
	 * @参数： @param j    
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
