package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

@PostConstruct
   public void init(){
        User user = new User();
        user.setName("Mucahit");
        user.setSurname("Gunhan");
        userRepository.save(user);
    }

@PostMapping
    public  ResponseEntity<User> add(@RequestBody User user){
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping
    public  ResponseEntity<List<User>> getList(){
        return ResponseEntity.ok(userRepository.findAll());
    }

}
