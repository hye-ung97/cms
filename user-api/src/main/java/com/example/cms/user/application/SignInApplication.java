package com.example.cms.user.application;

import com.example.cms.user.domain.SignInForm;
import com.example.cms.user.domain.model.Customer;
import com.example.cms.user.domain.model.Seller;
import com.example.cms.user.exception.CustomException;
import com.example.cms.user.service.customer.CustomerService;
import com.example.cms.user.service.seller.SellerService;
import com.zerobase.domain.config.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.cms.user.exception.ErrorCode.LOGIN_CHECK_FAIL;
import static com.zerobase.domain.common.UserType.CUSTOMER;
import static com.zerobase.domain.common.UserType.SELLER;

@Service
@RequiredArgsConstructor
public class SignInApplication {

    private final CustomerService customerService;
    private final SellerService sellerService;
    private final JwtAuthenticationProvider provider;
    public String customerLoginToken(SignInForm form){
        //1. 로그인 가능 여부
        Customer c = customerService.findValidCustomer(form.getEmail(), form.getPassword())
                .orElseThrow(() -> new CustomException(LOGIN_CHECK_FAIL));
        //2. 토큰 발생
        //3. 토큰 응답
        return provider.createToken(c.getEmail(), c.getId(), CUSTOMER);
    }

    public String sellerLoginToken(SignInForm form) {
        //1. 로그인 가능 여부
        Seller seller = sellerService.findValidSeller(form.getEmail(), form.getPassword())
                .orElseThrow(() -> new CustomException(LOGIN_CHECK_FAIL));
        //2. 토큰 발생
        //3. 토큰 응답
        return provider.createToken(seller.getEmail(), seller.getId(), SELLER);
    }
}
