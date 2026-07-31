package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {

    private String userId;

    private String productId;

    private Integer quantity;

}