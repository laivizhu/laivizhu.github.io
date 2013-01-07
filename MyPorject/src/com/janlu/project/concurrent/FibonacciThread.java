/**
 * 
 */
package com.janlu.project.concurrent;

import java.util.concurrent.Callable;

import com.janlu.util.DataArrayUtil;

/**
 * @author janlu
 *
 */
public class FibonacciThread extends BaseThread implements Callable<Integer> {
	private int n;
	private int[] array;
	

	public FibonacciThread(int n) {
		super();
		this.n = n;
		array=new int[n];
	}


	@Override
	public Integer call() throws Exception {
		generate();
		System.out.println(out(DataArrayUtil.toString(array)));
		return summary();
	}
	
	public void generate(){
		array[0]=1;
		array[1]=1;
		for(int i=2;i<n;i++){
			array[i]=array[i-1]+array[i-2];
		}
	}
	
	public int summary(){
		int sum=0;
		for(int value:array){
			sum+=value;
		}
		return sum;
	}
	

}
