package com.laivi.sic.test;


import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.File;
import java.util.Date;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.laivi.crawler.Crawler;
import com.laivi.crawler.model.LinkFilter;
import com.laivi.maptable.GenerateMysqlTable;
import com.laivi.sic.model.po.blog.Article;
import com.laivi.sic.service.task.TestJob;
import com.laivi.sic.util.basic.DataUtil;
import com.laivi.sic.util.basic.ExcelUtil;

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
	
	@Test
	public void testGenerateMysqlTable(){
		GenerateMysqlTable mysql=new GenerateMysqlTable();
		System.out.println(mysql.generateCreate(Article.class));
	}
	
	@Test
	public void testExcelUtil(){
		WritableWorkbook book=ExcelUtil.getWritetWorkBook("test.xls");
		WritableSheet sheet=ExcelUtil.getSheet(book, 0);
		System.out.println(sheet.getCell(5, 1).getContents());
		ExcelUtil.close(book);
	}
	
	@Test
	public void testCrawler(){
		String[] seeds={"http://www.timetimetime.net"};
		TimeArticleParser parser=new TimeArticleParser(new LinkFilter(){
			@Override
			public boolean accept(String url) {
				if (url.matches("http://www.timetimetime.net/yuedu/[\\d]+.html")
	        			|| url.matches("http://www.timetimetime.net/yulu/[\\d]+.html")
	        			|| url.matches("http://www.timetimetime.net/shenghuo/[\\d]+.html")
	        			|| url.matches("http://www.timetimetime.net/sanwen/[\\d]+.html")
	        			|| url.matches("http://www.timetimetime.net/zhuti/[\\d]+.html")) {
	        			String[] fileterUrls={};
	        			for(String filterUrl:fileterUrls){
	        				if(filterUrl.equals(url)){
	        					return false;
	        				}
	        			}
	        			return true;
	        		} else {
	        			return false;
	        		}
			}
		},new LinkFilter(){
			@Override
			public boolean accept(String url) {
				if(url.startsWith("http://www.timetimetime.net/")){
					return true;
				}
				return false;
			}
		},seeds);
		Crawler crawler=new Crawler();
		crawler.crawling(parser);
	}
	
	@Test
	public void testDate(){
		Date now=new Date();
		System.out.println("currentDate second:"+now.getSeconds());
	}
}
