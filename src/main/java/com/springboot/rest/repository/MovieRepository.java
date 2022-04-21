package com.springboot.rest.repository;

import com.springboot.rest.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    //all CRUD Database Methods
}
