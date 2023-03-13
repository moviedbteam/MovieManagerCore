package com.bcefit.projet.domain.analytic;

import com.bcefit.projet.domain.moviedb.Tv;
import com.bcefit.projet.domain.user.UserAccount;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tv_recommendation_blacklist")
public class TvRecommendationBlackListed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserAccount userAccount;

    @ManyToOne(fetch = FetchType.EAGER)
    private Tv tv;

    LocalDate date;

    public TvRecommendationBlackListed() {
    }

    public TvRecommendationBlackListed(Long id, UserAccount userAccount, Tv tv, LocalDate date) {
        this.id = id;
        this.userAccount = userAccount;
        this.tv = tv;
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

    public Tv getTv() {
        return tv;
    }

    public void setTv(Tv tv) {
        this.tv = tv;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
