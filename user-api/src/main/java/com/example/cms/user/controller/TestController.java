package com.example.cms.user.controller;

import com.example.cms.user.client.MailgunClient;
import com.example.cms.user.client.mailgun.SendMailForm;
import com.example.cms.user.service.test.EmailSendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final MailgunClient mailgunClient;

    @GetMapping
    public String sendTestEmail(){
        SendMailForm form = SendMailForm.builder()
                .subject("test")
                .to("hysung714@naver.com")
                .from("hysung714@naver.com")
                .text("hello this is test email")
                .build();
        return mailgunClient.sendMail(form).getBody();
    }
}
