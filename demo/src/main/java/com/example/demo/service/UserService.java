package com.example.demo.service;

import com.example.demo.DemoApplication;
import com.example.demo.repository.UserRepository;
import com.example.demo.domain.User;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final DemoApplication demoApplication;

    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository, DemoApplication demoApplication) {
        this.userRepository = userRepository;
        this.demoApplication = demoApplication;
    }


    public String handleHello() {
        return "Hello form service";
    }
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }
    public List<User> getAllUsersByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }
    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }
    public void DeleteUserById(long id) {
        this.userRepository.deleteById(id);
    }
}
