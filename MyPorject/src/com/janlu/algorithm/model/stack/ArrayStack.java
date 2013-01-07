/**
 * 
 */
package com.janlu.algorithm.model.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class ArrayStack<T> implements Stack<T> {
	private List<T> stack;
	
	public ArrayStack(){
		stack=new ArrayList<T>();
	}

	@Override
	public T pop() {
		if(stack.size()==0){
			return null;
		}
		return stack.get(stack.size()-1);
	}

	@Override
	public void push(T n) {
		stack.add(n);
	}

	@Override
	public int getCurrentCount() {
		return stack.size();
	}

}
