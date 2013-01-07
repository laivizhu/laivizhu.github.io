/**
 * 
 */
package com.janlu.algorithm.model.stack;

/**
 * @author Administrator
 *
 */
public interface Stack<T> {

	void push(T n);
	
	T pop();
	
	int getCurrentCount();
}
