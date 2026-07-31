package com.example.demo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {

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