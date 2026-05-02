package com.task.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.Model.User;
import com.task.Respository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    public User signup(User user) {
        return repo.save(user);
    }

    public User login(User user) {
        return repo.findAll().stream()
                .filter(u -> u.getEmail().equals(user.getEmail())
                        && u.getPassword().equals(user.getPassword()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}
