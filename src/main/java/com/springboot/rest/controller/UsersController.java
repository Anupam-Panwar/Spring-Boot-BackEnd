package com.springboot.rest.controller;

import com.springboot.rest.config.JwtTokenUtil;
import com.springboot.rest.model.JwtResponse;
import com.springboot.rest.model.Movie;
import com.springboot.rest.model.UserMovieRating;
import com.springboot.rest.model.User;
import com.springboot.rest.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController
{
    @Autowired
    private UserServices userServices;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    //Adds User into the Database
    @PostMapping("/registration")
    public String add(@RequestBody User user) {
        String response = userServices.insertUsers(user);
        return response;
    }

    //Logins User into the system
    @PostMapping("/login")
    public ResponseEntity<?>  login(@RequestBody User user) throws Exception {
        try {
            User result = userServices.loginUsers(user);
            final String token = jwtTokenUtil.generateToken(result);
            return ResponseEntity.ok(new JwtResponse(token));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Credentials");
        }

    }

    //Adds users rating of the movie into the database
    @PostMapping("/rate")
    public String userMovieRating(@RequestBody UserMovieRating userMovieRating, @RequestHeader("Authorization") String jwtToken) {
        jwtToken = jwtToken.substring(7);
        return userServices.userMovieRating(userMovieRating,jwtToken);
    }
}
