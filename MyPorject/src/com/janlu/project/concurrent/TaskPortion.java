/**
 * 
 */
package com.janlu.project.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author janlu
 *
 */
public class TaskPortion extends BaseThread implements Runnable {

	private static Random rand=new Random(47);
	private final CountDownLatch latch;
	
	public TaskPortion(CountDownLatch latch) {
		super();
		this.latch = latch;
	}


	@Override
	public void run() {
		try {
			doWork();
			latch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void doWork()throws InterruptedException{
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
		System.out.println(out("completed"));
	}

	
	

}
