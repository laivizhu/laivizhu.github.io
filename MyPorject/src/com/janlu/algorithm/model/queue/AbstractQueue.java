/**
 * 
 */
package com.janlu.algorithm.model.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author janlu
 *
 */
public abstract class AbstractQueue<T> implements Queue<T> {
	protected  List<T> queue;
	@Override
	public int size() {
		return queue.size();
	}

	@Override
	public boolean contains(Object o) {
		return queue.contains(o);
	}

	@Override
	public Iterator<T> iterator() {
		return queue.iterator();
	}

	@Override
	public Object[] toArray() {
		return queue.toArray();
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a) {
		return queue.toArray(a);
	}

	@Override
	public boolean add(T e) {
		return queue.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return queue.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return queue.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return queue.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return queue.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return queue.retainAll(c);
	}

	@Override
	public void clear() {
		queue.clear();
	}
	
}
