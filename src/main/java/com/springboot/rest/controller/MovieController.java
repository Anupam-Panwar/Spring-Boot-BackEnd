package com.springboot.rest.controller;

import com.springboot.rest.service.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController
{
    @Autowired
    private MovieServices movieServices;

    @GetMapping("/add")
    public String add() {
        movieServices.insertMovie();
        return "Movies Successfully added to the Database";
    }

    @GetMapping("/rating")
    public List<List<String>> movieRating(){
        return movieServices.movieRating();
    }
}