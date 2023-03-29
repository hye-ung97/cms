package com.example.cms.user.service.test;

import com.example.cms.user.client.MailgunClient;
import com.example.cms.user.client.mailgun.SendMailForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSendService {
    private final MailgunClient mailgunClient;

    public String sendEmail(){
        SendMailForm form = SendMailForm.builder()
                .from("hysung714@naver.com")
                .to("hysung714@naver.com")
                .subject("Test eamil from zero base")
                .text("my text")
                .build();

        return mailgunClient.sendMail(form).getBody();
    }
}
