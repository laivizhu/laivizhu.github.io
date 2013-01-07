/**
 * 
 */
package com.janlu.algorithm.model.heap;

import com.janlu.exception.AlgorithmException;

/**
 * @author janlu
 * �Ѷ������ӿڷ���
 */
public interface Heap {
	/**
	 * 
	 * ��������˵��
	 * �޸�������janlu �޸�����  2012-9-11
	 * �޸�����
	 * @������ @param n
	 * @������ @throws AlgorithmException    
	 * @return void   
	 * @throws
	 */
	public void add(int n) throws AlgorithmException;
	/**
	 * 
	 * ��������˵��
	 * �޸�������janlu �޸�����  2012-9-11
	 * �޸�����
	 * @������ @param n
	 * @������ @throws AlgorithmException    
	 * @return void   
	 * @throws
	 */
	public void remove(int n) throws AlgorithmException;
	/**
	 * 
	 * ��������˵��
	 * �޸�������janlu �޸�����  2012-9-11
	 * �޸�����
	 * @������ @param n
	 * @������ @return    
	 * @return int   
	 * @throws
	 */
	public int search(int n);
	/**
	 * 
	 * ��������˵��
	 * �޸�������janlu �޸�����  2012-9-11
	 * �޸�����
	 * @������ @return    
	 * @return int   
	 * @throws
	 */
	public int getHeapSize();
	
	/**
	 * 
	 * ��������˵��
	 * �޸�������janlu �޸�����  2012-9-11
	 * �޸�����
	 * @������     
	 * @return void   
	 * @throws
	 */
	public void sort();
	
	/**
	 * 
	 * ��������˵��:��ȡ���Ķ���
	 * �޸�������janlu �޸�����  2012-9-18
	 * �޸�����
	 * @������ @return    
	 * @return int   
	 * @throws
	 */
	public int extractMaxNum();
	
}
