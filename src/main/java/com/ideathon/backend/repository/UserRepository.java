package com.ideathon.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    // Function to register a new user
    public int registerUser(String userName,String email,String password,int contact,String location,int pincode){
        return jdbcTemplate.update("EXEC dbo.sp_register_user ?,?,?,?,?,?",userName,email,password,contact,location,pincode);
    }

    public Map<String, Object> validateUser(String userName, String password){
        System.out.println("resource service ");

        return this.jdbcTemplate.queryForMap("EXEC dbo.sp_fetchUserDetails ?, ?",userName,password);
    }
}
