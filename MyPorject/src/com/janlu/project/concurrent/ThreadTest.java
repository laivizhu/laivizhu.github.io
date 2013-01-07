/**
 * 
 */
package com.janlu.project.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author janlu
 *
 */
public class ThreadTest extends BaseThread implements Runnable {
	
	public ThreadTest(){
		System.out.println(out("new Thread Test"));
	}

	@Override
	public void run() {
		System.out.println(out("First Message"));
		/*Thread.yield();
		System.out.println(out("Second Message"));
		Thread.yield();
		System.out.println(out("Third Message"));
		Thread.yield();*/
		
		try {
			//TimeUnit.MILLISECONDS.sleep(100);
			System.out.println(out("Second Message"));
			//TimeUnit.MILLISECONDS.sleep(100);
			System.out.println(out("Third Message"));
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(out("Exit Message"));
	}

}
