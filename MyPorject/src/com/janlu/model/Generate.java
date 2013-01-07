/**
 * 
 */
package com.janlu.model;

/**
 * @author janlu
 *
 */
public class Generate<T> {
	private Class<T> type;
	
	public Generate(Class<T> type) {
		super();
		this.type = type;
	}

	public  static <T> Generate<T> create(Class<T> classObject){
		return new Generate<T>(classObject);
	}
	
	public T next(){
		try {
			return type.newInstance();
		} catch (InstantiationException e) {
			System.out.println("Generator Instantce Error!");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
