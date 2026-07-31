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
@Document(collection = "addresses")
public class Address {

    @Id
    private String id;

    private String userId;

    private String fullName;

    private String mobileNumber;

    private String houseNo;

    private String street;

    private String city;

    private String state;

    private String pinCode;

    private String country;

}