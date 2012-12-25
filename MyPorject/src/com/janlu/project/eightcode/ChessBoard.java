/**
 * 
 */
package com.janlu.project.eightcode;

import java.util.Arrays;

import com.janlu.type.Direction;
import com.janlu.util.ObjectUtil;


/**
 * @author janlu
 *
 */
public class ChessBoard{
	private int[][] chess;
	private int Blank_row;
	private int Blank_column;
	private Direction dir;

	public ChessBoard(int n){
		this.chess=new int[n][n];
	}

	public ChessBoard(int[][] chess) {
		this.chess = chess;
		for(int i=0;i<chess.length;i++){
			for(int j=0;j<chess[i].length;j++){
				if(chess[i][j]==0){
					this.Blank_row=i;
					this.Blank_column=j;
				}
			}
		}
	}

	public ChessBoard(int[][] chess, int blank_row, int blank_column) {
		super();
		this.chess = chess;
		Blank_row = blank_row;
		Blank_column = blank_column;	
	}

	public boolean isUp(){
		if(this.Blank_row==0){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean isDown(){
		if(this.Blank_row==chess.length-1){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean isRight(){
		if(this.Blank_column==chess.length-1){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean isLeft(){
		if(this.Blank_column==0){
			return false;
		}else{
			return true;
		}
	}
	
	public void toUp(){
		if(isUp()){
			swap(this.Blank_row-1,this.Blank_column);
			this.Blank_row--;
		}
	}
	
	public void toDown(){
		if(isDown()){
			swap(this.Blank_row+1,this.Blank_column);
			this.Blank_row++;
		}
	}
	
	public void toRight(){
		if(isRight()){
			swap(this.Blank_row,this.Blank_column+1);
			this.Blank_column++;
		}
	}
	
	public void toLeft(){
		if(isLeft()){
			swap(this.Blank_row,this.Blank_column-1);
			this.Blank_column--;
		}
	}
	
	public void swap(int dstRow,int dstColomn){
		int temp=chess[this.Blank_row][this.Blank_column];
		chess[this.Blank_row][this.Blank_column]=chess[dstRow][dstColomn];
		chess[dstRow][dstColomn]=temp;
	}
	
	public void toDirection(Direction dir){
		switch(dir){
		case Down:
			this.toDown();
			break;
		case Left:
			this.toLeft();
			break;
		case Right:
			this.toRight();
			break;
		case Up:
			this.toUp();
			break;
		}
	}
	
	public boolean isDirection(Direction dir){
		switch(dir){
		case Down:
			if(this.isDown()){
				return true;
			}
			break;
		case Left:
			if(this.isLeft()){
				return true;
			}
			break;
		case Right:
			if(this.isRight()){
				return true;
			}
			break;
		case Up:
			if(this.isUp()){
				return true;
			}
			break;
		}
		return false;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(chess);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChessBoard other = (ChessBoard) obj;
		return ObjectUtil.equalArray(chess, other.chess);
	}
	
	public int[][] getChess() {
		return chess;
	}

	public int getBlank_row() {
		return Blank_row;
	}

	public int getBlank_column() {
		return Blank_column;
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}
	
}
