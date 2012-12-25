/**
 * 
 */
package com.janlu.project.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author janlu
 *
 */
public class WaitingTask extends BaseThread implements Runnable {
	private final CountDownLatch latch;
	
	public WaitingTask(CountDownLatch latch) {
		super();
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			latch.await();
			System.out.println(out("Latch barrier passed"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
