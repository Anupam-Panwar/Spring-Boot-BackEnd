package com.springboot.rest.controller;

import com.springboot.rest.model.Movie;
import com.springboot.rest.service.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    //Return list of movies to the valid user
    @PostMapping("/list")
    public ResponseEntity<?> getMovieList() {
        try {

            List<Movie> response = new ArrayList<>();
            response = movieServices.getMovieList();
            if (response.size() == 0) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Movies are not present in the database");
            }
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error fetching Movies from the database");
        }
    }

    //Returns rating of movies from the database
    @GetMapping("/average-rating")
    public ResponseEntity<?> movieRating(){
        List<List<String>> result = movieServices.movieRating();
        if(result.size() == 0)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error Fetching average Movie rating");
        else
            return ResponseEntity.ok(result);
    }
}