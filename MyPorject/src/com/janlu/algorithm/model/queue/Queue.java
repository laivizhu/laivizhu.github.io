/**
 * 
 */
package com.janlu.algorithm.model.queue;

import java.util.Collection;
import java.util.List;

/**
 * @author janlu
 *
 */
public interface Queue<T> extends Collection<T>{
	
	/**
	 * 
	 * 函数功能说明:出队
	 * 修改者名字janlu 修改日期  2012-10-5
	 * 修改内容
	 * @参数： @return    
	 * @return T   
	 * @throws
	 */
	T outQueue();
	
	/**
	 * 
	 * 函数功能说明:是否从后面出队
	 * 修改者名字janlu 修改日期  2012-10-6
	 * 修改内容
	 * @参数： @param isFromBack
	 * @参数： @return    
	 * @return T   
	 * @throws
	 */
	T outQueue(boolean isFromBack);
	
	
	/**
	 * 
	 * 函数功能说明:入队
	 * 修改者名字janlu 修改日期  2012-10-5
	 * 修改内容
	 * @参数： @param object    
	 * @return void   
	 * @throws
	 */
	void InQueue(T object);
	
	
	/**
	 * 
	 * 函数功能说明:是否从前面进队
	 * 修改者名字janlu 修改日期  2012-10-6
	 * 修改内容
	 * @参数： @param object
	 * @参数： @param isInFromFront    
	 * @return void   
	 * @throws
	 */
	void InQueue(T object,boolean isInFromFront);
	
	
	/**
	 * 
	 * 函数功能说明:获取队列的数量
	 * 修改者名字janlu 修改日期  2012-10-5
	 * 修改内容
	 * @参数： @return    
	 * @return int   
	 * @throws
	 */
	int getCount();
	
	
	
	/**
	 * 
	 * 函数功能说明:删除队列的所有元素
	 * 修改者名字janlu 修改日期  2012-10-5
	 * 修改内容
	 * @参数：     
	 * @return void   
	 * @throws
	 */
	void removeAll();
	
	
	
	/**
	 * 
	 * 函数功能说明:队列是否为空
	 * 修改者名字janlu 修改日期  2012-10-5
	 * 修改内容
	 * @参数： @return    
	 * @return boolean   
	 * @throws
	 */
	boolean isEmpty();
	
	/**
	 * 
	 * 函数功能说明:获取第一个对象
	 * 修改者名字janlu 修改日期  2012-10-5
	 * 修改内容
	 * @参数： @return    
	 * @return T   
	 * @throws
	 */
	T getFirstObject();
	
	/**
	 * 
	 * 函数功能说明:获取最后一个对象
	 * 修改者名字janlu 修改日期  2012-10-6
	 * 修改内容
	 * @参数： @return    
	 * @return T   
	 * @throws
	 */
	T getLastObject();
	
	
	List<T> getQueue();
	
}
