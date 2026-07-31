package com.example.demo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartResponse {

    private String id;

    private String userId;

    private String productId;

    private Integer quantity;

    private UserResponse user;

    private ProductResponse product;

}