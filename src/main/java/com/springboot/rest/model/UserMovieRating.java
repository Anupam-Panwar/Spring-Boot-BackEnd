package com.springboot.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_rating")
public class UserMovieRating
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "rating")
    private int rating;

    public UserMovieRating(int movieId, int userId, int rating) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
    }
}
