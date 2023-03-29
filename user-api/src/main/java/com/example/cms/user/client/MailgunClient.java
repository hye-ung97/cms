package com.example.cms.user.client;

import com.example.cms.user.client.mailgun.SendMailForm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "mailgun", url = "https://api.mailgun.net/v3/")
@Qualifier("mailgun")
public interface MailgunClient {

    @PostMapping("sandboxd6d2c72b78374912b8c3de2cf4393e6b.mailgun.org/messages")
    ResponseEntity<String> sendMail(@SpringQueryMap SendMailForm form);
}
