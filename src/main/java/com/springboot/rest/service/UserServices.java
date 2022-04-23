package com.springboot.rest.service;

import com.springboot.rest.config.JwtTokenUtil;
import com.springboot.rest.model.Movie;
import com.springboot.rest.model.UserMovieRating;
import com.springboot.rest.model.User;
import com.springboot.rest.repository.MovieRepository;
import com.springboot.rest.repository.UserMovieRatingRepository;
import com.springboot.rest.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    //Method to register user into the database
    public String insertUsers(User user) {
        try {
            authenticate(user.getEmailId(), user.getPassword());
            usersRepository.save(user);
            return "Successfully Added User";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    private void authenticate(String emailId, String password) throws Exception {
        if(emailId.length() == 0)
            throw new Exception("Email can not be empty");
        else if(password.length() <8)
            throw new Exception("Password must be of length >= 8");
        else if(emailId.contains("@") == false)
            throw new Exception("Invalid Email Id");
        else
        {
            boolean flag = false;
            for(int i = 0; i<password.length(); i++)
            {
                if(password.contains(Integer.toString(i)) == true)
                {
                    flag = true;
                    break;
                }
            }
            if(flag == false)
                throw new Exception("Password must contain a digit");
        }
    }

    //Method to allow user to login to the system
    public User loginUsers(User user)throws Exception {
            User userDatabase = usersRepository.findByEmailId(user.getEmailId());
            if (user.getPassword().equals(userDatabase.getPassword()))
                return userDatabase;
            else
                throw new Exception("Invalid Password for email id : " + user.getEmailId());
    }


    //Method to add custom rating of usres for particular movie in database
    public String userMovieRating(UserMovieRating userMovieRating, String jwtToken) {
        try{
            String emailId = jwtTokenUtil.getEmailIdFromToken(jwtToken);
            User user = usersRepository.findByEmailId(emailId);
            int userId = (int)user.getId();
            userMovieRating.setUserId(userId);
            long movieId = (int)userMovieRating.getMovieId();
            Optional<Movie> movie = movieRepository.findById(movieId);
            if(movie.isPresent() == false)
                return "Invalid Movie Id";
            userMovieRatingRepository.save(userMovieRating);
            return "Rating added successfully";
        }
        catch (Exception e) {
            return "Error Adding Custom Rating";
        }

    }
}
