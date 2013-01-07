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
	 * ��������˵����λͼ����
	 * �޸�������janlu �޸�����  2012-9-3
	 * �޸�����
	 * @������ @param bitLength
	 * @������ @param datas    
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
	 * ��������˵��:�ݹ��������
	 * �޸�������janlu �޸�����  2012-9-4
	 * �޸�����
	 * @������ @param datas
	 * @������ @param start
	 * @������ @param end    
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
	 * ��������˵��:��һ���ַ�������ַ���������
	 * �޸�������janlu �޸�����  2012-9-3
	 * �޸�����
	 * @������ @param str
	 * @������ @return    
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
	 * ��������˵��:��������
	 * �޸�������janlu �޸�����  2012-9-4
	 * �޸�����
	 * @������ @param datas    
	 * @return void   
	 * @throws
	 */
	@RunTime(message="Quick Sort Time:")
	public  void quickSort(int[] datas){
		quickSort(datas,0,datas.length-1);
	}
	
	
	/**
	 * 
	 * ��������˵��:ð������
	 * �޸�������janlu �޸�����  2012-9-4
	 * �޸�����
	 * @������ @param datas    
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
	 * ��������˵����ѡ������
	 * �޸������� janlu �޸�����  2012-9-8
	 * �޸�����
	 * @������ @param datas    
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
	 * ��������˵��:����������鲢����
	 * �޸�������janlu �޸�����  2012-9-10
	 * �޸�����
	 * @������ @param datas    
	 * @return void   
	 * @throws
	 */
	@RunTime(message="Meger Sort Time:")
	public  void megerSort(int[] datas){
		megerSort(datas,0,datas.length);
	}
	
	/**
	 * 
	 * ��������˵��:���ض�����й鲢����
	 * �޸�������janlu �޸�����  2012-9-10
	 * �޸�����
	 * @������ @param datas
	 * @������ @param start
	 * @������ @param end    
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
	 * ��������˵��:����������������������ϲ�
	 * �޸�������janlu �޸�����  2012-9-10
	 * �޸�����
	 * @������ @param datas
	 * @������ @param start
	 * @������ @param mid
	 * @������ @param end    
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
	 * ��������˵��:���Ѿ��ź����������������
	 * �޸�������janlu �޸�����  2012-9-10
	 * �޸�����
	 * @������ @param datas
	 * @������ @param start
	 * @������ @param end    
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
	 * ��������˵��:
	 * �޸�������janlu �޸�����  2012-9-11
	 * �޸�����
	 * @������ @param datas
	 * @������ @param i
	 * @������ @param heapSize    
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
	 * ��������˵��:�������
	 * �޸�������janlu �޸�����  2012-9-11
	 * �޸�����
	 * @������ @param datas    
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
	 * ��������˵��:������
	 * �޸�������janlu �޸�����  2012-9-11
	 * �޸�����
	 * @������ @param datas    
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
