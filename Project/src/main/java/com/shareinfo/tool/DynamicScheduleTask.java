//package com.shareinfo.tool;
//
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//import org.springframework.scheduling.support.CronTrigger;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.time.LocalDateTime;
//
///**
// * @author zxx
// * @date 2019/7/5 21:16
// */
//@Component
//@Configuration //1.主要用于标记配置类，兼备Component的效果。
//@EnableScheduling // 2.开启定时任务
//
//public class DynamicScheduleTask implements SchedulingConfigurer {
//    @Mapper
//    public interface CronMapper {
//        @Select("select cron from cron limit 1")
//        public String getCron();
//    }
//
//    @Autowired //注入mapper
//    @SuppressWarnings("all")
//    CronMapper cronMapper;
//
//    /**
//     * 执行定时任务.
//     */
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//    }
//}
