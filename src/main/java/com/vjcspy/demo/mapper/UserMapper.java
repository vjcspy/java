package com.vjcspy.demo.mapper;

import com.vjcspy.demo.dto.request.UserCreationRequest;
import com.vjcspy.demo.entity.User;

public class UserMapper {

    public static User toEntity(UserCreationRequest userCreationRequest) {
        if (userCreationRequest == null) {
            return null;
        }

        User user = new User();
        user.setUsername(userCreationRequest.getUsername());
        user.setEmail(userCreationRequest.getEmail());
        user.setPassword(userCreationRequest.getPassword()); // Assuming password is already hashed
        return user;
    }
}