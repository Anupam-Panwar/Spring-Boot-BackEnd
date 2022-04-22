package com.springboot.rest.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie")
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "poster")
    private String poster_path;

    @Column(name = "runtime")
    private long  runtime;

    @Column(name = "overview")
    private String overview;

    @Column(name = "avg_rating")
    private long avgRating;

    public Movie(String title){
        this.title = title;
    }
}
