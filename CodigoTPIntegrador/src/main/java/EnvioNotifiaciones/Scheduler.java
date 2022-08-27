package EnvioNotifiaciones;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

public class Scheduler {


    public void comenzar() throws SchedulerException{

        // Creacion del scheduler
        SchedulerFactory schedFactory = new org.quartz.impl.StdSchedulerFactory();
        org.quartz.Scheduler scheduler = schedFactory.getScheduler();

        // Construccion de JobDetail
        JobBuilder jobBuilder = JobBuilder.newJob(JobEnvioNotificacionesImpl.class);
        JobDataMap data = new JobDataMap();
        JobDetail jobDetail = jobBuilder
                .withIdentity("Envio Notificacion")
                .usingJobData(data)
                .build();

        String cron = "0/15 * * * * ? *"; //segundos 0 15 30 y 45 de cada minuto
        Trigger trigger = TriggerBuilder.newTrigger()
                .startAt(new Date())
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }


    public Scheduler() {
    }
}