package com.springboot.rest.service;

import com.springboot.rest.model.Movie;
import com.springboot.rest.model.UserMovieRating;
import com.springboot.rest.model.Users;
import com.springboot.rest.repository.MovieRepository;
import com.springboot.rest.repository.UserMovieRatingRepository;
import com.springboot.rest.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServices {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserMovieRatingRepository userMovieRatingRepository;

    public void insertUsers(Users users) {
        usersRepository.save(users);
    }

    public String loginUsers(Users users) {
        try {
            Users userDatabase = usersRepository.findByEmailId(users.getEmailId());

            if (users.getPassword().equals(userDatabase.getPassword()))
                return "User Successfully Logged In";
            else
                return "Wrong Password";
        }
        catch (Exception e) {
            return ("User not exist with email id "+users.getEmailId()+" in database");
        }
    }

    public List<Movie> getMovieList(Users users) {
        String res = loginUsers(users);
        if(res.equals("User Successfully Logged In"))
            return movieRepository.findAll();
        else
            return Collections.emptyList();
    }

    public String userMovieRating(UserMovieRating userMovieRating) {
        userMovieRatingRepository.save(userMovieRating);
        return "Rating added successfully";
    }
}
