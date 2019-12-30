package org.chp.sboot.test.schedule.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author jeff
 * <p>Date: 2019-11-11 17:49:00</p>
 */
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println(Thread.currentThread().getName() + " hello");
    }
}
