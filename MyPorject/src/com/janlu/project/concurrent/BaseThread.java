/**
 * 
 */
package com.janlu.project.concurrent;

/**
 * @author janlu
 *
 */
public class BaseThread {
	private static int value=0;
	private final int i=value++;
	
	public String out(String message){
		return "Thread "+i+" "+message;
	}
	
	public int getThreadFlag(){
		return i;
	}
}
