package com.example.spring.task.service;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author yulshi
 * @create 2020/06/14 15:57
 */
@Service
public class MailService {

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * 发送clear text邮件
     *
     * @param to
     */
    public void sendClearText(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Welcome to the simple mail msg");
        message.setText("这是一个邮件测试，使用plain text格式发送");
        message.setTo(to);
        message.setFrom("shiyulongwudi@qq.com");
        mailSender.send(message);
    }

    /**
     * 发送HTML格式文件，并附带附件功能
     *
     * @param to
     * @throws MessagingException
     */
    public void sendHtmlWithAttach(String to) throws MessagingException {

        // 获得一个MimeMessage实例
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        // 使用MimeMessageHelper简化邮件内容设置的工作
        // 注意第二个参数设置为true，表示发送附件
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

        // 设置邮件标题和内容
        messageHelper.setSubject("A HTML test mail");
        messageHelper.setText("这是一个邮件<b style='color: red'>" +
                "测试</b>，使用<b>HTML</b>格式发送！", true);

        // 设置邮件的from和to
        messageHelper.setFrom("shiyulongwudi@qq.com");
        messageHelper.setTo(to);

        // 添加邮件附件
        messageHelper.addAttachment("file1",
                new File("/Users/yushi/.m2/settings.xml"));

        // 发送邮件
        mailSender.send(mimeMessage);

    }


}
