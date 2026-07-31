package com.example.demo.request;

import com.example.demo.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserRequest {

    private String name;

    private String email;

    private String password;

    private String phone;

    private Role role;

}
