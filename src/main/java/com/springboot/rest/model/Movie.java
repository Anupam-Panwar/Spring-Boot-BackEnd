package com.springboot.rest.model;

import lombok.*;

import javax.persistence.*;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public long getRuntime() {
        return runtime;
    }

    public void setRuntime(long runtime) {
        this.runtime = runtime;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public long getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(long avgRating) {
        this.avgRating = avgRating;
    }
}
