package com.paxian.controller;

import com.paxian.db.UserRepository;
import com.paxian.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class PublicApiController {

    public UserRepository userRepository;

    public PublicApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("all")
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("admin/profile")
    public String getAdmin() {
        return "{\"" + "message" + "\":\"" + "Welcome to SpringBoot Jwt Admin" + "\"}";
    }

    @GetMapping("management/reports")
    public String getManager() {
        return "{\"" + "message" + "\":\"" + "API for Managers only!" + "\"}";
    }
}
