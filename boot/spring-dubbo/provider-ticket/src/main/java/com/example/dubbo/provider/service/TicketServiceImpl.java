package com.example.dubbo.provider.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * @author yulshi
 * @create 2020/06/15 17:13
 */
@Service
@DubboService
public class TicketServiceImpl implements TickSerivce {
  @Override
  public String getTicket() {
    return "Jocker";
  }
}
