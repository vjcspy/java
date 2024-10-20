package com.vjcspy.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vjcspy.demo.dto.request.UserCreationRequest;
import com.vjcspy.demo.entity.User;
import com.vjcspy.demo.mapper.UserMapper;
import com.vjcspy.demo.repository.UserRepository;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(UserCreationRequest user) {
        // Check if the username is already taken
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already taken");
        }
        // Check if the email is already taken
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already taken");
        }
        // Map UserCreationRequest to User entity
        User newUser = UserMapper.toEntity(user);

        // Save the user
        return userRepository.save(newUser);
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}