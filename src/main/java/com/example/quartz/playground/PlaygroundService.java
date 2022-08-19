package com.example.quartz.playground;


import com.example.quartz.TimerService.SchedulerService;
import com.example.quartz.info.TimeInfo;
import com.example.quartz.jobs.timestampjob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaygroundService {
    private final SchedulerService scheduler;

    @Autowired
    public PlaygroundService(final SchedulerService scheduler) {
        this.scheduler= scheduler;
    }

    public void runTimestamp(){
        final TimeInfo info = new TimeInfo();
        info.setRepeatIntervalMs(30000);
        info.setInitialOffsetMs(1000);
        info.setCallbackData("My callback data");

        scheduler.Schedule(timestampjob.class, info);

    }
}
