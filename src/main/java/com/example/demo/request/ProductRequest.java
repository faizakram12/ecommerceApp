package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    private String productName;

    private String description;

    private Double price;

    private Integer stock;

    private String categoryId;

}