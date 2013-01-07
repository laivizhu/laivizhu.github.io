/**
 * 
 */
package com.janlu.util;

import java.util.Arrays;
import java.util.BitSet;

import com.janlu.annotation.RunTime;

/**
 * @author janlu
 *
 */
public class SortUtil {
	
	/**
	 * 
	 * 函数功能说明：位图排序
	 * 修改者名字janlu 修改日期  2012-9-3
	 * 修改内容
	 * @参数： @param bitLength
	 * @参数： @param datas    
	 * @return void   
	 * @throws
	 */
	@RunTime(message="Bit Sort Time:")
	public void bitSetSort(int bitLength,int[] datas){
		BitSet set=new BitSet(bitLength);
		for(int data:datas){
			set.set(data,true);
		}
		int k=0;
		for(int i=0;i<bitLength;i++){
			if(set.get(i)){
				datas[k++]=i;
			}
		}
	}
	
	
	/**
	 * 
	 * 函数功能说明:递归快速排序
	 * 修改者名字janlu 修改日期  2012-9-4
	 * 修改内容
	 * @参数： @param datas
	 * @参数： @param start
	 * @参数： @param end    
	 * @return void   
	 * @throws
	 */
	private static void quickSort(int[] datas,int start,int end){
		if(start>=0 && start <end && end<datas.length){
			int i=start;
			int j=end;
			int k=datas[start];
			int position=start;
			while(i<j){
				while(j>=0 && datas[j]>=k){
					j--;
				}
				if(j<i){
					break;
				}
				datas[position]=datas[j];
				position=j;
				while(i<datas.length && datas[i]<=k){
					i++;
				}
				if(j<i){
					break;
				}
				datas[position]=datas[i];
				position=i;
			}
			datas[position]=k;
			quickSort(datas,start,position-1);
			quickSort(datas,position+1,end);
		}
	}
	
	
	/**
	 * 
	 * 函数功能说明:对一个字符串里的字符进行排序
	 * 修改者名字janlu 修改日期  2012-9-3
	 * 修改内容
	 * @参数： @param str
	 * @参数： @return    
	 * @return String   
	 * @throws
	 */
	public static String sortString(String str){
		char[] chars=str.toLowerCase().toCharArray();
		Arrays.sort(chars);
		return Arrays.toString(chars);
	}
	
	
	/**
	 * 
	 * 函数功能说明:快速排序
	 * 修改者名字janlu 修改日期  2012-9-4
	 * 修改内容
	 * @参数： @param datas    
	 * @return void   
	 * @throws
	 */
	@RunTime(message="Quick Sort Time:")
	public  void quickSort(int[] datas){
		quickSort(datas,0,datas.length-1);
	}
	
	
	/**
	 * 
	 * 函数功能说明:冒泡排序
	 * 修改者名字janlu 修改日期  2012-9-4
	 * 修改内容
	 * @参数： @param datas    
	 * @return void   
	 * @throws
	 */
	@RunTime(message="Bulb Sort Time:")
	public void bulbSort(int[] datas){
		for(int i=datas.length-1;i>=0;i--){
			for(int j=0;j<i;j++){
				if(datas[j]>datas[j+1]){
					DataArrayUtil.swap(datas,j,j+1);
				}
			}
		}
	}

	/**
	 * 
	 * 函数功能说明：选择排序
	 * 修改者名字 janlu 修改日期  2012-9-8
	 * 修改内容
	 * @参数： @param datas    
	 * @return void   
	 * @throws
	 */
	@RunTime(message="Choice Sort Time:")
	public void choiceSort(int[] datas){
		for(int i=datas.length-1;i>=0;i--){
			for(int j=0;j<i;j++){
				if(datas[j]>datas[i]){
					DataArrayUtil.swap(datas,i,j);
				}
			}
		}
	}
	
	/**
	 * 
	 * 函数功能说明:对整个数组归并排序
	 * 修改者名字janlu 修改日期  2012-9-10
	 * 修改内容
	 * @参数： @param datas    
	 * @return void   
	 * @throws
	 */
	@RunTime(message="Meger Sort Time:")
	public  void megerSort(int[] datas){
		megerSort(datas,0,datas.length);
	}
	
	/**
	 * 
	 * 函数功能说明:对特定域进行归并排序
	 * 修改者名字janlu 修改日期  2012-9-10
	 * 修改内容
	 * @参数： @param datas
	 * @参数： @param start
	 * @参数： @param end    
	 * @return void   
	 * @throws
	 */
	private static void megerSort(int[] datas,int start,int end){
		if(start<end){
			int mid=(start+end)/2;
			megerSort(datas,start,mid);
			megerSort(datas,mid+1,end);
			meger(datas,start,mid,end);
		}
	}
	
	
	/**
	 * 
	 * 函数功能说明:将两个有序的数组进行排序合并
	 * 修改者名字janlu 修改日期  2012-9-10
	 * 修改内容
	 * @参数： @param datas
	 * @参数： @param start
	 * @参数： @param mid
	 * @参数： @param end    
	 * @return void   
	 * @throws
	 */
	private static void meger(int[] datas,int start,int mid,int end){
		int i=start;
		int j=mid+1;
		while(i<=mid && j<datas.length){
			if(datas[i]>datas[j]){
				DataArrayUtil.swap(datas,i,j);
			}
			i++;
			inSort(datas,j,end);
		}
	}

	
	
	/**
	 * 
	 * 函数功能说明:对已经排好序的数组重新排序
	 * 修改者名字janlu 修改日期  2012-9-10
	 * 修改内容
	 * @参数： @param datas
	 * @参数： @param start
	 * @参数： @param end    
	 * @return void   
	 * @throws
	 */
	private static void inSort(int[] datas,int start,int end){
		for(int i=start;i<end;i++){
			if((i+1)<datas.length && datas[i]>datas[i+1]){
				DataArrayUtil.swap(datas,i,i+1);
			}else{
				break;
			}
		}
	}
	
	
	
	/**
	 * 
	 * 函数功能说明:
	 * 修改者名字janlu 修改日期  2012-9-11
	 * 修改内容
	 * @参数： @param datas
	 * @参数： @param i
	 * @参数： @param heapSize    
	 * @return void   
	 * @throws
	 */
	private static void maxHeapify(int[] datas,int i,int heapSize){
		int l=left(i);
		int r=right(i);
		int largest=i;
		if(l<=heapSize && datas[l]>datas[i]){
			largest=l;
		}
		if(r<=heapSize && datas[r]>datas[largest]){
			largest=r;
		}
		
		if(largest!=i){
			DataArrayUtil.swap(datas,i,largest);
			maxHeapify(datas,largest,heapSize);
		}
	}
	
	/**
	 * 
	 * 函数功能说明:建立大堆
	 * 修改者名字janlu 修改日期  2012-9-11
	 * 修改内容
	 * @参数： @param datas    
	 * @return void   
	 * @throws
	 */
	public static void buildMaxHeap(int[] datas){
		int heapSize=datas.length-1;
		for(int i=datas.length/2;i>=0;i--){
			maxHeapify(datas,i,heapSize);
		}
	}
	
	
	/**
	 * 
	 * 函数功能说明:堆排序
	 * 修改者名字janlu 修改日期  2012-9-11
	 * 修改内容
	 * @参数： @param datas    
	 * @return void   
	 * @throws
	 */
	@RunTime(message="Heap Sort Time:")
	public void heapSort(int[] datas){
		buildMaxHeap(datas);
		int heapSize=datas.length-1;
		for(int i=datas.length-1;i>=1;i--){
			DataArrayUtil.swap(datas,0,i);
			heapSize=heapSize-1;
			maxHeapify(datas,0,heapSize);
		}
	}
	
	private static int left(int i){
		return 2*i+1;
	}
	
	private static int right(int i){
		return 2*(i+1);
	}
	
}
