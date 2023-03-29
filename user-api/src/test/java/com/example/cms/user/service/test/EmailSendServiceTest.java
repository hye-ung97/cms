package com.example.cms.user.service.test;

import com.example.cms.user.client.MailgunClient;
import com.example.cms.user.client.mailgun.SendMailForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailSendServiceTest {

    @Autowired
    private MailgunClient mailgunClient;

    @Test
    void sendEmail() {
        SendMailForm form = SendMailForm.builder()
                .subject("test")
                .to("hysung714@naver.com")
                .from("hysung714@naver.com")
                .text("hello this is test email")
                .build();
        mailgunClient.sendMail(form);
    }
}