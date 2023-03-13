package com.bcefit.projet.domain.analytic;

import com.bcefit.projet.domain.moviedb.Movie;
import com.bcefit.projet.domain.moviedb.Tv;
import com.bcefit.projet.domain.user.UserAccount;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "movie_recommendation_blacklist")
public class MovieRecommendationBlackListed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserAccount userAccount;

    @ManyToOne(fetch = FetchType.EAGER)
    private Movie movie;

    LocalDate date;

    public MovieRecommendationBlackListed() {
    }

    public MovieRecommendationBlackListed(Long id, UserAccount userAccount, Movie movie, LocalDate date) {
        this.id = id;
        this.userAccount = userAccount;
        this.movie = movie;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
