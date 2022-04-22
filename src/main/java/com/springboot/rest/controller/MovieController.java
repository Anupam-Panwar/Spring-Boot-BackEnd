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

    //Adds movies to the database
    @GetMapping("/add")
    public String add() {
        String response = movieServices.insertMovie();
        return response;
    }

    //Returns rating of movies from the database
    @GetMapping("/rating")
    public List<List<String>> movieRating(){
        return movieServices.movieRating();
    }
}