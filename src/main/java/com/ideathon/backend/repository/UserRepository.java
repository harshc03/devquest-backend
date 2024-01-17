package com.ideathon.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    // Function to register a new user
    public int registerUser(String fullName,String userName,String email,String password,String dob,String bio){
        return jdbcTemplate.update("EXEC dbo.sp_register_user ?,?,?,?,?,?",fullName,userName,email,password,dob,bio);
    }
}
