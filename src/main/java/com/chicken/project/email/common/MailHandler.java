package com.chicken.project.email.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Component
public class MailHandler {
    private JavaMailSender mailSender;
    private MimeMessage message;
    private MimeMessageHelper messageHelper;

    @Autowired
    public MailHandler(JavaMailSender mailSender) throws MessagingException{

        this.mailSender = mailSender;
        message = this.mailSender.createMimeMessage();
        messageHelper =new MimeMessageHelper(message, true, "UTF-8");
    }

    // 제목
    public void setSubject(String subject) throws  MessagingException{
        messageHelper.setSubject(subject);
    }

    // 내용
    public void setText(String htmlContent) throws MessagingException{
        messageHelper.setText(htmlContent, true);
    }

    // 발송자
    public void setFrom(String email, String name) throws UnsupportedEncodingException, MessagingException{
        messageHelper.setFrom(email, name);
    }

    // 수신자
    public void setTo(String email) throws MessagingException{
        messageHelper.setTo(email);
    }

    public void addInline(String contentId, DataSource dataSource) throws MessagingException{
        messageHelper.addInline(contentId, dataSource);
    }

    // 보내기
    public void send(){
        mailSender.send(message);
    }

}