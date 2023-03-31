package com.example.cms.user.application;

import com.example.cms.user.domain.SignInForm;
import com.example.cms.user.domain.model.Customer;
import com.example.cms.user.exception.CustomException;
import com.example.cms.user.service.CustomerService;
import com.zerobase.domain.config.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.cms.user.exception.ErrorCode.LOGIN_CHECK_FAIL;
import static com.zerobase.domain.common.UserType.CUSTOMER;

@Service
@RequiredArgsConstructor
public class SignInApplication {

    private final CustomerService customerService;
    private final JwtAuthenticationProvider provider;
    public String customerLoginToken(SignInForm form){
        //1. 로그인 가능 여부
        Customer c = customerService.findValidCustomer(form.getEmail(), form.getPassword())
                .orElseThrow(() -> new CustomException(LOGIN_CHECK_FAIL));
        //2. 토큰 발생
        //3. 토큰 응답
        return provider.createToken(c.getEmail(), c.getId(), CUSTOMER);
    }
}
