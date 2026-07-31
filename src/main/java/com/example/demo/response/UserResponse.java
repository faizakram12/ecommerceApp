package com.example.demo.response;


import com.example.demo.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserResponse {
    private String id;

    private String name;

    private String email;

    private String phone;

    private Role role;

}
