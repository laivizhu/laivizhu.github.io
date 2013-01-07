/**
 * 
 */
package com.janlu.project.eightcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.janlu.algorithm.model.queue.LinkQueue;
import com.janlu.algorithm.model.queue.Queue;
import com.janlu.type.Direction;
import com.janlu.util.ObjectUtil;

/**
 * @author janlu
 *
 */
public class ChessCode {
	
	private Queue<Status> open=new LinkQueue<Status>();
	private Queue<Status> close=new LinkQueue<Status>();
	private int[][] dstChess;
	
	public ChessCode(int[][] chess,int [][] dstChess){
		open.InQueue(new Status(new ChessBoard(chess)));
		this.dstChess=dstChess;
	}
	
	public boolean matchSuccess(int[][] chess){
		return ObjectUtil.equalArray(chess, this.dstChess);
	}
	
	public int getSampleDegree(int[][] curChess){
		int sampleDegree=0;
		for(int i=0;i<dstChess.length;i++){
			for(int j=0;j<dstChess[i].length;j++){
				boolean isFound=false;
				int hamiton=0;
				for(int curI=0;curI<curChess.length;curI++){
					for(int curJ=0;curJ<curChess[curI].length;curJ++){
						if(dstChess[i][j]==curChess[curI][curJ]){
							isFound=true;
							hamiton=Math.abs(i-curI)+Math.abs(j-curJ);
							break;
						}
					}
					if(isFound){
						break;
					}
				}
				sampleDegree+=hamiton;
			}
		}
		return sampleDegree;
	}
	
	public int getSampleDegree(ChessBoard chess){
		return getSampleDegree(chess.getChess());
	}
	
	public boolean run(){
		boolean flag=false;
		while(!open.isEmpty()){
			Status parentStatus=open.getFirstObject();
			ChessBoard parent=parentStatus.getData();
			if(matchSuccess(parent.getChess())){
				flag=true;
				close.InQueue(parentStatus);
				break;
			}
			List<ChessBoard> chessList=this.getNextStep();
			for(ChessBoard chess:chessList){
				Status status=new Status(chess);
				status.setParent(parentStatus);
				status.setSampleDegree(getSampleDegree(status.getData()));
				status.setStep(parentStatus.getStep()+1);
				status.setDir(chess.getDir());
				open.InQueue(status,true);
			}
			Collections.sort(open.getQueue());
			close.InQueue(parentStatus);
		}
		return flag;
	}
	
	public List<ChessBoard> getNextStep(){
		if(open.isEmpty()){
			return null;
		}
		List<ChessBoard> list=new ArrayList<ChessBoard>();
		Status status=open.outQueue();
		ChessBoard curChess=status.getData();
		for(Direction dir:Direction.values()){
			if(curChess.isDirection(dir)){
				int[][] temp=new int[curChess.getChess().length][curChess.getChess().length];
				ObjectUtil.copyArray(curChess.getChess(), temp);
				ChessBoard chess=new ChessBoard(temp,curChess.getBlank_row(),curChess.getBlank_column());
				chess.toDirection(dir);
				chess.setDir(dir);
				if(!isExist(chess)){
					list.add(chess);
				}
			}
		}
		return list;
	}
	
	public boolean isExist(ChessBoard chess){
		for(Status tempStatus:this.close){
			if(tempStatus.getData()!=null && tempStatus.getData().equals(chess)){
				return true;
			}
		}
		return false;
	}
	
	public Queue<Status> getMatchStatus(){
		Queue<Status> matchStatus=new LinkQueue<Status>();
		Status status=close.getLastObject();
		matchStatus.InQueue(status);
		while((status=status.getParent())!=null){
			matchStatus.InQueue(status);
		}
		return matchStatus;
	}

	public Queue<Status> getClose() {
		return close;
	}
	
	
}
