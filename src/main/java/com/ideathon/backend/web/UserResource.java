package com.ideathon.backend.web;

import com.ideathon.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserResource {
    @Autowired
    UserService userService;
    @PostMapping("/user")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, Object> body){
//        System.out.println(body);
        return this.userService.registerUser(body);
    }
}
