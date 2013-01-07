/**
 * 
 */
package com.janlu.project.eightcode;

import com.janlu.type.Direction;


/**
 * @author janlu
 *
 */
public class Status  implements Comparable<Status>{
	private ChessBoard data;
	private Direction dir;
	private Status parent;
	private int step;
	private int sampleDegree;
	
	public Status(ChessBoard data) {
		this(data,1);
	}
	
	public Status(ChessBoard data,int step){
		super();
		this.data = data;
		this.step=step;
	}
	
	@Override
	public int compareTo(Status o) {
		int value1=this.getSampleDegree()+this.getStep();
		int value2=o.getSampleDegree()+o.getStep();
		return value1-value2;
	}
	
	public ChessBoard getData() {
		return data;
	}
	public Status getParent() {
		return parent;
	}
	public void setParent(Status parent) {
		this.parent = parent;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	
	public void setSampleDegree(int sampleDegree) {
		this.sampleDegree = sampleDegree;
	}

	public int getSampleDegree() {
		return sampleDegree;
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}
}
