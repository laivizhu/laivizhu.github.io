package com.laivi.sic.test;


import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.File;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.laivi.sic.service.task.TestJob;
import com.laivi.sic.util.basic.DataUtil;

public class MethodTest {
	private Scheduler scheduler;
	
	@Before
	public void init(){
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void close(){
		try {
			if(scheduler!=null){
				scheduler.shutdown();
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testSimple(){
		String str1="30条有关爱情的句子";
		String str2="30条有关爱情的句子";
		System.out.println("simple:"+DataUtil.getSimilarDegree(str1, str2));
	}
	
	@Test
	public void testFile(){
		File file=new File("WebRoot\\WEB-INF\\mailTemplate");
		System.out.println(file.isDirectory());
	}
	
	@Test
	public void testQuartz(){
		JobDetail job=newJob(TestJob.class).withIdentity("job1", "group1").build();
		
		Trigger trigger=newTrigger().withIdentity("trigger1", "group1").startAt(evenMinuteDate(new Date())).build();
		//Date startTime=DateBuilder.
		try {
			scheduler.scheduleJob(job, trigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		try {
            Thread.sleep(65L * 1000L); 
        } catch (Exception e) {
        }
	}
}
