/**
 * 
 */
package com.janlu.project.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author janlu
 *
 */
public class Horse extends BaseThread implements Runnable {

	private int strides=0;
	private static Random rand=new Random(47);
	private static CyclicBarrier barrier;

	@SuppressWarnings("static-access")
	public Horse(CyclicBarrier barrier){
		this.barrier=barrier;
	}
	
	public synchronized int getStrides(){
		return this.strides;
	}

	@Override
	public void run() {
		try{
			while(!Thread.interrupted()){
				synchronized(this){
					strides+=rand.nextInt(3);
				}
				barrier.await();
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public String tracks(){
		StringBuilder s=new StringBuilder();
		for(int i=0;i<getStrides();i++){
			s.append("*");
		}
		s.append(this.getThreadFlag());
		return s.toString();
	}
	
	public String toString(){
		return "Horse "+this.getThreadFlag();
	}

}
