package com.springboot.rest.controller;

import com.springboot.rest.model.Movie;
import com.springboot.rest.model.UserMovieRating;
import com.springboot.rest.model.Users;
import com.springboot.rest.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController
{
    @Autowired
    private UserServices userServices;

    @PostMapping("/add")
    public String add(@RequestBody Users users) {
        userServices.insertUsers(users);
        return "Successfully Registered User";
    }

    @PostMapping("/login")
    public String login(@RequestBody Users users) {
        String result = userServices.loginUsers(users);
        return result;
    }

    @PostMapping("/list")
    public List<Movie> getMovieList(@RequestBody Users users) {
        return (List<Movie>) userServices.getMovieList(users);
    }

    @PostMapping("/rate")
    public String userMovieRating(@RequestBody UserMovieRating userMovieRating) {
        return userServices.userMovieRating(userMovieRating);
    }
}
