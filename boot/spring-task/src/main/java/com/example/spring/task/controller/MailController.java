package com.example.spring.task.controller;

import com.example.spring.task.service.MailService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

/**
 * @author yulshi
 * @create 2020/06/14 16:17
 */
@RestController
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/task/mail/clear/{to}")
    public String sendClearText(@PathVariable("to") String to) {
        mailService.sendClearText(to);
        return "mail sent";
    }

    @GetMapping("/task/mail/html/{to}")
    public String sendHtml(@PathVariable("to") String to) throws MessagingException {
        mailService.sendHtmlWithAttach(to);
        return "mail sent";
    }

    @ExceptionHandler
    public String catchException(Exception e) {
        System.out.println(e);
        return "exception occurred: " + e;
    }

}
