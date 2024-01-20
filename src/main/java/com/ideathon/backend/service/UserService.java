package com.ideathon.backend.service;

import com.ideathon.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    //    Function to register a new user
    public ResponseEntity<String> registerUser(Map<String,Object> body){
//        String fullName = (String) body.get("fullName");
        String userName = (String) body.get("userName");
        String email = (String) body.get("email");
        String password = (String) body.get("password");
        int contact = (int) body.get("contact");
        String location = (String) body.get("location");
        int pincode = (int) body.get("pincode");
//        System.out.println(fullName+" "+userName+" "+email+" "+password+" "+dob+" "+bio);
        int noOfRows = userRepository.registerUser(userName,email,password,contact,location,pincode);
        if(noOfRows > 0 ) return ResponseEntity.ok("Successfully Registered");
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Registration failed");
    }

}
