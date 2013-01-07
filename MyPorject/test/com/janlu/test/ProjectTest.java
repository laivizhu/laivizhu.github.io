/**
 * 
 */
package com.janlu.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

import com.janlu.algorithm.model.queue.Queue;
import com.janlu.project.concurrent.B;
import com.janlu.project.concurrent.DaemonThreadFactory;
import com.janlu.project.concurrent.FibonacciThread;
import com.janlu.project.concurrent.HorseRace;
import com.janlu.project.concurrent.TaskPortion;
import com.janlu.project.concurrent.ThreadTest;
import com.janlu.project.concurrent.WaitingTask;
import com.janlu.project.eightcode.ChessCode;
import com.janlu.project.eightcode.Status;
import com.janlu.project.measurewater.Bottle;
import com.janlu.project.measurewater.MeasureWater;
import com.janlu.util.ObjectUtil;
import com.janlu.util.OutPrintUtil;

/**
 * @author janlu
 *
 */
public class ProjectTest {
	
	@Test
	public void testMeasureWater(){
		Bottle[] bottles=getBottles();
		MeasureWater measure=new MeasureWater(bottles,15,9);
		measure.measure();
	}
	
	private Bottle[] getBottles(){
		int[] caps={19,16,13};
		boolean[] isMoves={true,true,true};
		Bottle[] bottles=new Bottle[caps.length];
		for(int i=0;i<caps.length;i++){
			bottles[i]=new Bottle(caps[i],isMoves[i]);
		}
		return bottles;
	}
	
	@Test
	public void testChessCode(){
		int[][] dstchess={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
		int[][] chess={{0,3,6,4},{2,1,7,8},{5,10,9,15},{13,14,12,11}};
		ChessCode code=new ChessCode(chess,dstchess);
		if(code.run()){
			Queue<Status> matchStatus=code.getMatchStatus();
			OutPrintUtil.outMessage("可以找到移动路劲,移动步数为："+matchStatus.getCount());
			int i=0;
			while(!matchStatus.isEmpty()){
				i++;
				Status status=matchStatus.outQueue(true);
				System.out.println("the "+i+" Step:"+ObjectUtil.outArray(status.getData().getChess())+",移动方向为："+ObjectUtil.toString(status.getDir()));
			}
			System.out.println(code.getClose().getCount());
		}else{
			OutPrintUtil.outMessage("无法找到移动路劲");
		}
	}
	
	@Test
	public void testThread(){
		ExecutorService exec=Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i=0;i<10;i++){
			exec.execute(new ThreadTest());
		}
		exec.shutdown();
		System.out.println("Main Thread Exit");
	}
	
	@Test
	public void testThread1(){
		ExecutorService exec=Executors.newCachedThreadPool();
		List<Future<Integer>> results=new ArrayList<Future<Integer>>();
		
		for(int i=0;i<10;i++){
			results.add(exec.submit(new FibonacciThread(10+i)));
		}
		
		for(Future<Integer> fs:results){
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}finally{
				exec.shutdown();
			}
		}
	}
	
	@Test
	public void testThreadSync(){
		Object object=new Object();
		
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			exec.execute(new B(object));
		}
		synchronized(object){
			try {
				object.wait();
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
				e.printStackTrace();
			}
		}
		System.out.println("Main Execute Finish!");
		exec.shutdown();
	}
	
	@Test
	public void testCountDownLatch() throws InterruptedException{
		ExecutorService exec=Executors.newCachedThreadPool();
		CountDownLatch latch=new CountDownLatch(9);
		for(int i=0;i<10;i++){
			exec.execute(new WaitingTask(latch));
		}
		for(int i=0;i<9;i++){
			exec.execute(new TaskPortion(latch));
		}
		latch.await();
		exec.shutdown();
		System.out.println("Main Execute Finish!");
	}
	
	@Test
	public void testCyclicBarrier(){
		int nHorses=7;
		int pause=200;
		new HorseRace(nHorses,pause);
	}
	
	@Test
	public void testOr(){
		int a=3,b=4;
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println(a+" "+b);
	}

}
