package com.example.androidexamen.Model;

import java.util.List;
import java.util.Vector;

public class Peliculas {
    private String title, poster_path, original_language, original_title, backdrop_path, overview, release_date;
    private Boolean video, adult;
    private Integer id, vote_vount;
    private Double vote_average, popularity;
    private Vector<Integer> genre_id;

    public Peliculas(String title, String poster_path, String original_language, String original_title, String backdrop_path, String overview, String release_date, Boolean video, Boolean adult, Integer id, Integer vote_vount, Double vote_average, Double popularity, Vector<Integer> genre_id) {
        this.title = title;
        this.poster_path = poster_path;
        this.original_language = original_language;
        this.original_title = original_title;
        this.backdrop_path = backdrop_path;
        this.overview = overview;
        this.release_date = release_date;
        this.video = video;
        this.adult = adult;
        this.id = id;
        this.vote_vount = vote_vount;
        this.vote_average = vote_average;
        this.popularity = popularity;
        this.genre_id = genre_id;
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

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVote_vount() {
        return vote_vount;
    }

    public void setVote_vount(Integer vote_vount) {
        this.vote_vount = vote_vount;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Vector<Integer> getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Vector<Integer> genre_id) {
        this.genre_id = genre_id;
    }
}
