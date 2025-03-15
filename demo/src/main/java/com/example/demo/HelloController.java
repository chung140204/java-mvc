package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {
    @GetMapping("/")
    public String index() {
        return "Hello World from Chung";
    }
    @GetMapping("/user")
    public String userPage() {
        return "Only user";
    }
    @GetMapping("/admin")
    public String adminPage() {
        return "Only admin";
    }
    
    
}
