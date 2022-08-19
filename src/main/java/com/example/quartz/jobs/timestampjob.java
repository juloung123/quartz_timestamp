package com.example.quartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class timestampjob implements Job {
    private static final Logger LOG = LoggerFactory.getLogger(timestampjob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        LocalDateTime currnttime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String timestamp = currnttime.format(formatter);
        LOG.info(timestamp);
    }
}
