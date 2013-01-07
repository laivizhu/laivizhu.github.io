/**
 * 
 */
package com.janlu.project.concurrent;

import java.util.concurrent.ThreadFactory;

/**
 * @author janlu
 *
 */
public class DaemonThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread thread=new Thread(r);
		thread.setDaemon(true);
		return thread;
	}

}
