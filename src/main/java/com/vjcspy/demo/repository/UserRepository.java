package com.vjcspy.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vjcspy.demo.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
    User findByEmail(String email);
}
