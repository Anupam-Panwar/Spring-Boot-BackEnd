package com.springboot.rest.service;

import com.springboot.rest.exception.ResourceNotFoundException;
import com.springboot.rest.model.Movie;
import com.springboot.rest.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServices {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private MovieRepository movieRepository;

    //Method to add Movies into the database
    public String insertMovie()
    {
        try {
            movieRepository.deleteAll();
            int count = 0;
            for (int i = 100; i <= 110; i++) {
                String url = "https://api.themoviedb.org/3/movie/" + i + "?api_key=" + apiKey;
                RestTemplate restTemplate = new RestTemplate();

                Movie movieSummary = restTemplate.getForObject(url, Movie.class);
                movieRepository.save(movieSummary);
                count++;
            }
            if(count == 11)
                return "Successfully Added movies in the database";
            else
                return "Successfully Added few movies in the database";

        }
        catch(Exception e) {
            return "Error while loading the movies in the database";
        }
    }

    //Method to return ratings of the movie
    public List<List<String>> movieRating()
    {
        try {
            List<Movie> tempResult = movieRepository.findAll();
            List<List<String>> result = new ArrayList<>();
            for (Movie t : tempResult) {
                List<String> temp = new ArrayList<>();
                temp.add(t.getTitle());
                long avgRating = t.getAvgRating();
                if (avgRating == 0)
                    temp.add("NA");
                else
                    temp.add(Long.toString(avgRating));

                result.add(temp);
            }
            return result;
        }
        catch (Exception e) {
            List<List<String>> response = new ArrayList<>();
            return response;
        }
    }

    //Method to fetch movies from the database
    public List<Movie> getMovieList() throws Exception{
        return movieRepository.findAll();
    }
}
