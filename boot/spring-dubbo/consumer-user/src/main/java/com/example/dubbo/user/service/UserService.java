package com.example.dubbo.user.service;

import com.example.dubbo.provider.service.TickSerivce;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author yulshi
 * @create 2020/06/15 21:37
 */
@Service
public class UserService {

    @DubboReference
    private TickSerivce tickSerivce;

    public String buyTicket() {
        String ticket = tickSerivce.getTicket();
        return "Bought the ticket for " + ticket;
    }

}
