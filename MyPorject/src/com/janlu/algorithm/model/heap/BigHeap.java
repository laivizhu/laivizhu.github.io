/**
 * 
 */
package com.janlu.algorithm.model.heap;

import com.janlu.contents.Constants;
import com.janlu.contents.Constants.AlgorithmConstants;
import com.janlu.exception.AlgorithmException;
import com.janlu.util.DataArrayUtil;
import com.janlu.util.ParamAssert;

/**
 * @author janlu
 *
 */
public class BigHeap implements Heap{
	private int size=Constants.AlgorithmConstants.Value.ArrayTotalSize;
	private int[] heap;
	private int heapSize=0;
	
	
	public BigHeap(int size) {
		this(new int[size],0);
	}
	
	public BigHeap(int[] heap){
		this(heap,heap.length);
	}
	
	public BigHeap(int[] heap,int heapSize){
		if(heap.length>this.size && heapSize>heap.length){
			throw new IllegalArgumentException(AlgorithmConstants.Error.HeapOutError);
		}
		this.heapSize=heapSize;
		this.heap=heap;
		buildMaxHeap();
	}

	@Override
	public void add(int n) throws AlgorithmException {
		ParamAssert.isTrue((this.heapSize+1)>this.size, AlgorithmConstants.Error.HeapOutError);
		heap[this.heapSize++]=n;
		moveParent(this.heapSize-1);
	}

	@Override
	public void remove(int n) throws AlgorithmException  {
		ParamAssert.isTrue((this.heapSize-1)<0, AlgorithmConstants.Error.HeapOutError);
		int index=search(n);
		if(index==-1){
			ParamAssert.isTrue(true,AlgorithmConstants.Message.NotFoundMessage);
		}else{
			move(index);
		}
		this.heapSize--;
	}

	@Override
	public int search(int n) {
		return find(n,0);
	}

	@Override
	public int getHeapSize() {
		return this.heapSize;
	}

	
	@Override
	public void sort() {
		int tempheapSize=this.heapSize-1;
		for(int i=this.heapSize-1;i>=1;i--){
			DataArrayUtil.swap(heap,0,i);
			tempheapSize=tempheapSize-1;
			bigHeapify(0,tempheapSize);
		}
	}

	/**
	 * 
	 * 函数功能说明：
	 * 修改者名字janlu 修改日期  2012-9-11
	 * 修改内容
	 * @参数： @param i
	 * @参数： @param heapSize    
	 * @return void   
	 * @throws
	 */
	private void bigHeapify(int i,int heapSize){
		int l=left(i);
		int r=right(i);
		int largest=i;
		if(l<=heapSize && heap[l]>heap[i]){
			largest=l;
		}
		if(r<=heapSize && heap[r]>heap[largest]){
			largest=r;
		}
		if(largest!=i){
			DataArrayUtil.swap(heap,i,largest);
			bigHeapify(largest,heapSize);
		}
	}
	
	/**
	 * 
	 * 函数功能说明:返回左节点索引
	 * 修改者名字janlu 修改日期  2012-9-11
	 * 修改内容
	 * @参数： @param i
	 * @参数： @return    
	 * @return int   
	 * @throws
	 */
	private int left(int i){
		return 2*i+1;
	}
	
	/**
	 * 
	 * 函数功能说明:返回右子节点索引
	 * 修改者名字janlu 修改日期  2012-9-11
	 * 修改内容
	 * @参数： @param i
	 * @参数： @return    
	 * @return int   
	 * @throws
	 */
	private int right(int i){
		return 2*(i+1);
	}
	
	/**
	 * 
	 * 函数功能说明:返回父节点索引
	 * 修改者名字janlu 修改日期  2012-9-11
	 * 修改内容
	 * @参数： @param i
	 * @参数： @return    
	 * @return int   
	 * @throws
	 */
	private int parent(int i){
		if(i==0){
			return 0;
		}else{
			return (i-1)/2;
		}
	}
	
	/**
	 * 
	 * 函数功能说明:将一个数组构建成堆
	 * 修改者名字janlu 修改日期  2012-9-11
	 * 修改内容
	 * @参数：     
	 * @return void   
	 * @throws
	 */
	private void buildMaxHeap(){
		for(int i=this.heapSize/2;i>=0 && this.heapSize>0;i--){
			bigHeapify(i,this.heapSize-1);
		}
	}
	
	
	/**
	 * 
	 * 函数功能说明:从特定位置查找
	 * 修改者名字janlu 修改日期  2012-9-11
	 * 修改内容
	 * @参数： @param n
	 * @参数： @param i
	 * @参数： @return    
	 * @return int   
	 * @throws
	 */
	private int find(int n,int i){
		if(i>this.heapSize){
			return -1;
		}
		if(n==heap[i]){
			return i;
		}else{
			int temp=find(n,left(i));
			if(temp==-1){
				return find(n,right(i));
			}else{
				return temp;
			}
		}
	}
	
	/**
	 * 
	 * 函数功能说明:删除节点移动
	 * 修改者名字janlu 修改日期  2012-9-11
	 * 修改内容
	 * @参数： @param i    
	 * @return void   
	 * @throws
	 */
	private void move(int i){
		if(left(i)<this.heapSize && right(i)>=this.heapSize){
			heap[i]=heap[left(i)];
			move(left(i));
		}else if(left(i)>=this.heapSize && right(i)<this.heapSize){
			heap[i]=heap[right(i)];
			move(right(i));
		}else if(left(i)<this.heapSize && right(i)<this.heapSize){
			if(heap[left(i)]>=heap[right(i)]){
				heap[i]=heap[left(i)];
				move(left(i));
			}else{
				heap[i]=heap[right(i)];
				move(right(i));
			}
		}else if(left(i)>=this.heapSize && right(i)>=this.heapSize){
			for(int j=this.heapSize-1;j>i;j--){
				if(heap[parent(i)]>heap[j]){
					heap[i]=heap[j];
					break;
				}
			}
		}
		
	}
	
	/**
	 * 
	 * 函数功能说明:移动子节点
	 * 修改者名字:janlu 修改日期  2012-9-11
	 * 修改内容
	 * @参数： @param i    
	 * @return void   
	 * @throws
	 */
	private void moveParent(int i){
		if(i<this.heapSize&& i>0){
			if(heap[i]>heap[parent(i)]){
				DataArrayUtil.swap(heap,i,parent(i));
				moveParent(parent(i));
			}
		}
	}

	@Override
	public String toString() {
		return DataArrayUtil.toString(heap,this.heapSize);
	}

	/* (non-Javadoc)
	 * @see com.janlu.algorithm.structs.heap.Heap#extractMaxNum()
	 */
	@Override
	public int extractMaxNum() {
		int maxNum=0;
		if(this.heapSize>0){
			maxNum=heap[0];
			move(0);
			this.heapSize--;
		}
		return maxNum;
	}
	

}
