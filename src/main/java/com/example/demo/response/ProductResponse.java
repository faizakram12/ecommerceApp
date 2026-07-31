package com.example.demo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

    private String id;

    private String productName;

    private String description;

    private Double price;

    private Integer stock;

    private String categoryId;

    private ProductCategoryResponse category;

    private String imageUrl;

}