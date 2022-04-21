package com.springboot.rest.repository;

import com.springboot.rest.model.UserMovieRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMovieRatingRepository extends JpaRepository<UserMovieRating, Long>{
    //all CRUD Database Methods
}
