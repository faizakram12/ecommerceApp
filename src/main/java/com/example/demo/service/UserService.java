package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register User
    public UserResponse registerUser(UserRequest userRequest) {

        User user = new User();

        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setRole(userRequest.getRole());
        user.setPhone(userRequest.getPhone());

        User savedUser = userRepository.save(user);

        UserResponse userResponse = new UserResponse();

        userResponse.setId(savedUser.getId());
        userResponse.setName(savedUser.getName());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setPhone(user.getPhone());
        userResponse.setRole(savedUser.getRole());


        return userResponse;
    }

    // Get All Users
    public List<UserResponse> getAllUsers() {

        List<User> userList = userRepository.findAll();

        List<UserResponse> responseList = new ArrayList<>();

        for (User user : userList) {

            UserResponse response = new UserResponse();

            response.setId(user.getId());
            response.setName(user.getName());
            response.setEmail(user.getEmail());
            response.setRole(user.getRole());
            response.setPhone(user.getPhone());

            responseList.add(response);
        }

        return responseList;
    }

    // Get User By Id
    public UserResponse getUserById(String id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());

        return response;
    }

    // Update User
    public UserResponse updateUser(String id, UserRequest userRequest) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setRole(userRequest.getRole());
        user.setPhone(user.getPhone());

        User updatedUser = userRepository.save(user);

        UserResponse response = new UserResponse();

        response.setId(updatedUser.getId());
        response.setName(updatedUser.getName());
        response.setEmail(updatedUser.getEmail());
        response.setRole(updatedUser.getRole());
        response.setPhone(user.getPhone());

        return response;
    }

    // Delete User
    public void deleteUser(String id) {

        userRepository.deleteById(id);

    }



}