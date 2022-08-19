package com.example.quartz.TimerService;

import com.example.quartz.Util.TimerUtils;
import com.example.quartz.info.TimeInfo;
import com.example.quartz.jobs.timestampjob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class SchedulerService {
    private static final Logger LOG = LoggerFactory.getLogger(SchedulerService.class);
    private final Scheduler scheduler;

    @Autowired
    public SchedulerService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void Schedule(final Class jobclass, final TimeInfo info){
        final JobDetail jobDetail = TimerUtils.buildJobDetail(jobclass, info);

        final Trigger trigger = TimerUtils.buildTrigger(jobclass, info);

        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @PostConstruct
    public void init(){
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            LOG.error(e.getMessage());
        }
    }

    @PreDestroy
    public void PreDestroy(){
        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
