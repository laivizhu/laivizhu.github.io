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
	 * 函数功能说明:瓶子装自来水
	 * 修改者名字janlu 修改日期  2012-9-30
	 * 修改内容
	 * @参数：     
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
	 * 函数功能说明:瓶子倒掉全部的水
	 * 修改者名字janlu 修改日期  2012-9-30
	 * 修改内容
	 * @参数： @return    
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
	 * 函数功能说明:从其他瓶子装水
	 * 修改者名字janlu 修改日期  2012-9-30
	 * 修改内容
	 * @参数： @param bottle    
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
	 * 函数功能说明:把水倒到其他瓶子
	 * 修改者名字janlu 修改日期  2012-9-30
	 * 修改内容
	 * @参数： @param bottle    
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
	 * 函数功能说明:判断容器是否装满
	 * 修改者名字janlu 修改日期  2012-9-30
	 * 修改内容
	 * @参数： @return    
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
	 * 函数功能说明:判断容器是否是空的
	 * 修改者名字janlu 修改日期  2012-9-30
	 * 修改内容
	 * @参数： @return    
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
