package com.example.order.controller;

import com.example.order.application.CartApplication;
import com.example.order.domain.product.AddProductCartForm;
import com.example.order.domain.redis.Cart;
import com.zerobase.domain.config.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer/cart")
@RequiredArgsConstructor
public class CustomerCartController {

    private final JwtAuthenticationProvider provider;
    private final CartApplication cartApplication;

    @PostMapping
    public ResponseEntity<Cart> addCart(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                                        @RequestBody AddProductCartForm form){

        return ResponseEntity.ok(cartApplication.addCart(provider.getUserVo(token).getId(), form));
    }

    @GetMapping
    public ResponseEntity<Cart> showCart(@RequestHeader(name = "X-AUTH-TOKEN") String token){

        return ResponseEntity.ok(cartApplication.getCart(provider.getUserVo(token).getId()));
    }

    @PutMapping
    public ResponseEntity<Cart> updateCart(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                                           @RequestBody Cart cart){
        return ResponseEntity.ok(cartApplication.updateCart(provider.getUserVo(token).getId(), cart));
    }

}
