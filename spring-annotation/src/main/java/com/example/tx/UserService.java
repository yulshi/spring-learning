package com.example.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yulshi
 * @create 2020/06/04 21:32
 */
@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    ApplicationEventMulticaster multicaster;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional()
    public void insertTemp() {
        multicaster.multicastEvent(new ApplicationEvent("HHHHH") {
        });
        userDao.insert();
        int i = 10 / 2;
    }
}
