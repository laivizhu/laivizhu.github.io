package com.laivi.sic.service.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("start Job");
		System.out.println("starting Job");
		System.out.println("end Job");
	}

}
