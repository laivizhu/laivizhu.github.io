/**
 * 
 */
package com.janlu.project.concurrent;

/**
 * @author janlu
 *
 */
public class B extends BaseThread implements Runnable {
	private static int i=0;
	private Object object;
	
	public B(Object object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		System.out.println(out("Execute Finish"));
		synchronized(object){
			i++;
			if(i==10){
				object.notify();
			}
		}
	}
	

}
