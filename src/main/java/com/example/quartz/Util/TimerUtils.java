package com.example.quartz.Util;

import com.example.quartz.info.TimeInfo;
import org.quartz.*;

import java.util.Date;

public final class TimerUtils {
    private TimerUtils(){

    }

    public static JobDetail buildJobDetail(final Class jobclass, final TimeInfo info){
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(jobclass.getSimpleName(), info);

        return JobBuilder
                .newJob(jobclass)
                .withIdentity(jobclass.getSimpleName())
                .setJobData(jobDataMap)
                .build();
    }

    public static Trigger buildTrigger(final Class jobclass, final TimeInfo info){
        SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(info.getRepeatIntervalMs());

        if(info.isRunforever()){
            builder = builder.repeatForever();
        }
        else{
            builder = builder.withRepeatCount(info.getTotalFirecount() - 1);
        }

        return TriggerBuilder
                .newTrigger()
                .withIdentity(jobclass.getSimpleName())
                .withSchedule(builder)
                .startAt(new Date(System.currentTimeMillis() + info.getInitialOffsetMs() ))
                .build();
    }
}
