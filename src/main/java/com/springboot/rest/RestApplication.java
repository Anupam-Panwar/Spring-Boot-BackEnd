package com.springboot.rest;

import com.springboot.rest.controller.MovieController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication implements CommandLineRunner {

    public static void main(String[] args)  {
        SpringApplication.run(RestApplication.class, args);
    }

    @Autowired
    private MovieController movie;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(movie.add());
    }
}
