/**
 * 
 */
package com.janlu.algorithm.model.queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.janlu.contents.Constants;

/**
 * @author janlu
 *
 */
public class ArrayQueue<T> extends AbstractQueue<T> {

	public ArrayQueue() {
		super();
		queue=new ArrayList<T>();
	}

	@Override
	public T outQueue() {
		if(queue.size()==0){
			throw new ArrayIndexOutOfBoundsException(Constants.AlgorithmConstants.Error.ArrayOutError);
		}else{
			T object=null;
			object=queue.get(0);
			queue.remove(0);
			return object;
		}
	}

	@Override
	public void InQueue(T object) {
		queue.add(object);
	}

	@Override
	public int getCount() {
		return queue.size();
	}

	@Override
	public void removeAll() {
		queue.clear();
	}

	@Override
	public boolean isEmpty() {
		return queue.size()<=0;
	}
	
	@Override
	public T getFirstObject() {
		return queue.get(0);
	}
	
	@Override
	public void InQueue(T object, boolean isInFromFront) {
		if(isInFromFront){
			queue.add(0, object);
		}else{
			InQueue(object);
		}
		
	}

	@Override
	public Iterator<T> iterator() {
		return queue.iterator();
	}
	
	@Override
	public T getLastObject() {
		return queue.get(queue.size()-1);
	}
	
	@Override
	public T outQueue(boolean isFromBack) {
		if(isFromBack){
			if(queue.size()==0){
				throw new ArrayIndexOutOfBoundsException(Constants.AlgorithmConstants.Error.ArrayOutError);
			}else{
				T object=queue.get(queue.size()-1);
				queue.remove(queue.size()-1);
				return object;
			}
		}else{
			return outQueue();
		}
	}

	@Override
	public List<T> getQueue() {
		return queue;
	}

}
