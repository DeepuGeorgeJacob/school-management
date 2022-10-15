package com.school.scheduler.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // Let's start by configuring a task to run after a fixed delay:
    @Scheduled(fixedDelay = 5000)
    public void reportCurrentTime() {
        log.info("The time is now in fixedDelay {}", dateFormat.format(new Date()));
    }

    // Schedule a Task With Initial Delay
    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void scheduleFixedRateWithInitialDelayTask() {

        long now = System.currentTimeMillis() / 1000;
       log.info(
                "Fixed rate task with one second initial delay - " + now);
    }

    /**
     * This option should be used when each execution of the task is independent.
     *
     * Note that scheduled tasks don't run in parallel by default.
     * So even if we used fixedRate, the next task won't be invoked until the previous one is done.
     */
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        log.info(
                "Fixed rate task - " + dateFormat.format(new Date()));
    }



}
