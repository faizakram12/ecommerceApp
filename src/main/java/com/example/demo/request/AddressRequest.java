package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {

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