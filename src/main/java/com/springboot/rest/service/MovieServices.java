package com.springboot.rest.service;

import com.springboot.rest.model.Movie;
import com.springboot.rest.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServices {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private MovieRepository movieRepository;

    public void insertMovie()
    {
        movieRepository.deleteAll();
        for(int i = 100; i<=110; i++) {
            String url = "https://api.themoviedb.org/3/movie/"+i+"?api_key=" + apiKey;
            RestTemplate restTemplate = new RestTemplate();

            Movie movie_summary = restTemplate.getForObject(url, Movie.class);
            movieRepository.save(movie_summary);
        }
    }

    public List<List<String>> movieRating()
    {
        List<Movie> tempResult= movieRepository.findAll();
        List<List<String>> result = new ArrayList<>();
        for(Movie t : tempResult) {
            List<String> temp = new ArrayList<>();
            temp.add(t.getTitle());
            long avgRating = t.getAvgRating();
            if(avgRating == 0)
                temp.add("NA");
            else
                temp.add(Long.toString(avgRating));

            result.add(temp);
        }
        return result;
    }
}
