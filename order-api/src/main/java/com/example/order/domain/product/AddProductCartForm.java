package com.example.order.domain.product;

import com.example.order.domain.redis.Cart;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddProductCartForm {
    private Long id;
    private Long sellerId;
    private String name;
    private String description;
    private List<ProductItem> items;


    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductItem{
        private Long id;
        private String name;
        private Integer count;
        private Integer price;
    }
}
