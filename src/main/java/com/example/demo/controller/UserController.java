package com.example.demo.controller;



import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // Create User
    @PostMapping("/register")
    public UserResponse registerUser(@RequestBody UserRequest userRequest) {
        return userService.registerUser(userRequest);
    }

    // Get All Users
    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    // Update User
    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable String id,
                                   @RequestBody UserRequest userRequest) {
        return userService.updateUser(id, userRequest);
    }



    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable String id){

        return userService.getUserById(id);

    }
    // Delete User
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "User deleted successfully.";
    }



}