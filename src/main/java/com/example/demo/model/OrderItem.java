package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orderItems")
public class OrderItem {

    @Id
    private String id;

    private String orderId;

    private String productId;

    private String productName;

    private Integer quantity;

    private Double productPrice;

}