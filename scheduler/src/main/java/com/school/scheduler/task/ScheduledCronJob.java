package com.school.scheduler.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledCronJob {

    /**
     *  * * * * * *
     *  1 - second (0-59)
     *  2 - minute (0 - 59)
     *  3 - hour (0 - 23)
     *  4 - day of the month (1 - 31)
     *  5 - month (1 - 12) (or JAN-DEC)
     *  6 - day of the week (0 - 7) or (or MON-SUN -- 0 or 7 is Sunday)
     *
     */
    @Scheduled(cron = "0 15 10 15 * ?")
    public void scheduleTaskUsingCronExpression() {

        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "schedule tasks using cron jobs - " + now);
    }
}
