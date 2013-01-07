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
	 * ��������˵��:����
	 * �޸�������janlu �޸�����  2012-10-5
	 * �޸�����
	 * @������ @return    
	 * @return T   
	 * @throws
	 */
	T outQueue();
	
	/**
	 * 
	 * ��������˵��:�Ƿ�Ӻ������
	 * �޸�������janlu �޸�����  2012-10-6
	 * �޸�����
	 * @������ @param isFromBack
	 * @������ @return    
	 * @return T   
	 * @throws
	 */
	T outQueue(boolean isFromBack);
	
	
	/**
	 * 
	 * ��������˵��:���
	 * �޸�������janlu �޸�����  2012-10-5
	 * �޸�����
	 * @������ @param object    
	 * @return void   
	 * @throws
	 */
	void InQueue(T object);
	
	
	/**
	 * 
	 * ��������˵��:�Ƿ��ǰ�����
	 * �޸�������janlu �޸�����  2012-10-6
	 * �޸�����
	 * @������ @param object
	 * @������ @param isInFromFront    
	 * @return void   
	 * @throws
	 */
	void InQueue(T object,boolean isInFromFront);
	
	
	/**
	 * 
	 * ��������˵��:��ȡ���е�����
	 * �޸�������janlu �޸�����  2012-10-5
	 * �޸�����
	 * @������ @return    
	 * @return int   
	 * @throws
	 */
	int getCount();
	
	
	
	/**
	 * 
	 * ��������˵��:ɾ�����е�����Ԫ��
	 * �޸�������janlu �޸�����  2012-10-5
	 * �޸�����
	 * @������     
	 * @return void   
	 * @throws
	 */
	void removeAll();
	
	
	
	/**
	 * 
	 * ��������˵��:�����Ƿ�Ϊ��
	 * �޸�������janlu �޸�����  2012-10-5
	 * �޸�����
	 * @������ @return    
	 * @return boolean   
	 * @throws
	 */
	boolean isEmpty();
	
	/**
	 * 
	 * ��������˵��:��ȡ��һ������
	 * �޸�������janlu �޸�����  2012-10-5
	 * �޸�����
	 * @������ @return    
	 * @return T   
	 * @throws
	 */
	T getFirstObject();
	
	/**
	 * 
	 * ��������˵��:��ȡ���һ������
	 * �޸�������janlu �޸�����  2012-10-6
	 * �޸�����
	 * @������ @return    
	 * @return T   
	 * @throws
	 */
	T getLastObject();
	
	
	List<T> getQueue();
	
}
