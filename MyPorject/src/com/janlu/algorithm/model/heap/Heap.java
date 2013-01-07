/**
 * 
 */
package com.janlu.algorithm.model.heap;

import com.janlu.exception.AlgorithmException;

/**
 * @author janlu
 * 堆对象抽象接口方法
 */
public interface Heap {
	/**
	 * 
	 * 函数功能说明
	 * 修改者名字janlu 修改日期  2012-9-11
	 * 修改内容
	 * @参数： @param n
	 * @参数： @throws AlgorithmException    
	 * @return void   
	 * @throws
	 */
	public void add(int n) throws AlgorithmException;
	/**
	 * 
	 * 函数功能说明
	 * 修改者名字janlu 修改日期  2012-9-11
	 * 修改内容
	 * @参数： @param n
	 * @参数： @throws AlgorithmException    
	 * @return void   
	 * @throws
	 */
	public void remove(int n) throws AlgorithmException;
	/**
	 * 
	 * 函数功能说明
	 * 修改者名字janlu 修改日期  2012-9-11
	 * 修改内容
	 * @参数： @param n
	 * @参数： @return    
	 * @return int   
	 * @throws
	 */
	public int search(int n);
	/**
	 * 
	 * 函数功能说明
	 * 修改者名字janlu 修改日期  2012-9-11
	 * 修改内容
	 * @参数： @return    
	 * @return int   
	 * @throws
	 */
	public int getHeapSize();
	
	/**
	 * 
	 * 函数功能说明
	 * 修改者名字janlu 修改日期  2012-9-11
	 * 修改内容
	 * @参数：     
	 * @return void   
	 * @throws
	 */
	public void sort();
	
	/**
	 * 
	 * 函数功能说明:抽取最大的对象
	 * 修改者名字janlu 修改日期  2012-9-18
	 * 修改内容
	 * @参数： @return    
	 * @return int   
	 * @throws
	 */
	public int extractMaxNum();
	
}
