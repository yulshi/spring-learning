package com.example.dubbo.user.controller;

import com.example.dubbo.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yulshi
 * @create 2020/06/15 21:39
 */
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/ticket/buy")
    public String buyTicket() {
        return userService.buyTicket();
    }

}
