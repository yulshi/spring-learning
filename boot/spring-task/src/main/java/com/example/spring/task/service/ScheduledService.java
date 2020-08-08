package com.example.spring.task.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author yulshi
 * @create 2020/06/14 14:40
 */
@Service
@Slf4j
public class ScheduledService {

//  @Scheduled(cron = "0 * * * * MON-FRI")
  @Scheduled(cron = "0 * * ? * 0-5")
  public void scheduledTask() {
    log.info("a scheduled task is executing...");
  }
}
