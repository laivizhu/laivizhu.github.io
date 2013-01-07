/**
 * 
 */
package com.janlu.project.measurewater;

/**
 * @author janlu
 *
 */
public class Bottle {
	private int capacity;
	private boolean isMove;
	private int currentSize;
	
	public Bottle(int capacity){
		this(capacity,0);
	}
	
	public Bottle(int capacity,boolean isMove){
		this(capacity,isMove,0);
	}
	
	public Bottle(int capacity, int currentSize) {
		this(capacity,true,currentSize);
	}

	public Bottle(int capacity, boolean isMove, int currentSize) {
		this.capacity = capacity;
		this.isMove = isMove;
		this.currentSize = currentSize;
	}

	/**
	 * 
	 * ��������˵��:ƿ��װ����ˮ
	 * �޸�������janlu �޸�����  2012-9-30
	 * �޸�����
	 * @������     
	 * @return void   
	 * @throws
	 */
	public void boxingWater(){
		if(this.isMove){
			this.currentSize=this.capacity;
		}
	}
	
	private void boxingWater(int size){
		this.currentSize=this.currentSize+size;
		if(this.currentSize>this.capacity){
			this.currentSize=this.capacity;
		}
	}
	
	
	/**
	 * 
	 * ��������˵��:ƿ�ӵ���ȫ����ˮ
	 * �޸�������janlu �޸�����  2012-9-30
	 * �޸�����
	 * @������ @return    
	 * @return int   
	 * @throws
	 */
	public int pourWater(){
		if(this.isMove){
			int pourValue=this.currentSize;
			this.currentSize=0;
			return pourValue;
		}else{
			return 0;
		}
		
	}
	
	private void pourWater(int size){
		if(this.currentSize<=size){
			this.currentSize=0;
		}else{
			this.currentSize=this.currentSize-size;
		}
	}
	
	/**
	 * 
	 * ��������˵��:������ƿ��װˮ
	 * �޸�������janlu �޸�����  2012-9-30
	 * �޸�����
	 * @������ @param bottle    
	 * @return void   
	 * @throws
	 */
	public void boxingFromBottle(Bottle bottle){
		if(bottle.isMove){
			if((bottle.currentSize+this.currentSize)>this.capacity){
				int value=this.capacity-this.currentSize;
				this.boxingWater();
				bottle.pourWater(value);
			}else{
				this.boxingWater(bottle.currentSize);
				bottle.pourWater();
			}
		}
		
	}
	
	/**
	 * 
	 * ��������˵��:��ˮ��������ƿ��
	 * �޸�������janlu �޸�����  2012-9-30
	 * �޸�����
	 * @������ @param bottle    
	 * @return void   
	 * @throws
	 */
	public void pourToBottle(Bottle bottle){
		if(this.isMove){
			bottle.boxingFromBottle(this);
		}
	}
	
	/**
	 * 
	 * ��������˵��:�ж������Ƿ�װ��
	 * �޸�������janlu �޸�����  2012-9-30
	 * �޸�����
	 * @������ @return    
	 * @return boolean   
	 * @throws
	 */
	public boolean isFull(){
		if(this.capacity==this.currentSize){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 
	 * ��������˵��:�ж������Ƿ��ǿյ�
	 * �޸�������janlu �޸�����  2012-9-30
	 * �޸�����
	 * @������ @return    
	 * @return boolean   
	 * @throws
	 */
	public boolean isEmpty(){
		if(this.currentSize==0){
			return true;
		}else{
			return false;
		}
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getCurrentSize() {
		return currentSize;
	}
	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}

	public boolean isMove() {
		return isMove;
	}

	public void setMove(boolean isMove) {
		this.isMove = isMove;
	}
	
	
	
	
}
