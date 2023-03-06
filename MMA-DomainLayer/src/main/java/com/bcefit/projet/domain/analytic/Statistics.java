package com.bcefit.projet.domain.analytic;

import com.bcefit.projet.domain.user.UserAccount;

import javax.persistence.*;
import java.time.Duration;


@Entity
@Table(name = "statistic")
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UserAccount userAccount;
    private Duration durationEpsiodesWished;
    private Duration durationEpsiodesWatched;
    private Integer numberEpisodesWished;
    private Integer numberEpisodesWatched;
    private Duration durationMoviesWished;
    private Duration durationMoviesWatched;
    private Integer numberMoviesWished;
    private Integer numberMoviesWatched;

    public Statistics(Long id) {
        this.id = id;
    }

    public Statistics(Long id, UserAccount userAccount, Duration durationEpsiodesWished, Duration durationEpsiodesWatched, Integer numberEpisodesWished, Integer numberEpisodesWatched, Duration durationMoviesWished, Duration durationMoviesWatched, Integer numberMoviesWished, Integer numberMoviesWatched) {
        this.id = id;
        this.userAccount = userAccount;
        this.durationEpsiodesWished = durationEpsiodesWished;
        this.durationEpsiodesWatched = durationEpsiodesWatched;
        this.numberEpisodesWished = numberEpisodesWished;
        this.numberEpisodesWatched = numberEpisodesWatched;
        this.durationMoviesWished = durationMoviesWished;
        this.durationMoviesWatched = durationMoviesWatched;
        this.numberMoviesWished = numberMoviesWished;
        this.numberMoviesWatched = numberMoviesWatched;
    }

    public Statistics() {

    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Duration getDurationEpsiodesWished() {
        return durationEpsiodesWished;
    }

    public void setDurationEpsiodesWished(Duration durationEpsiodesWished) {
        this.durationEpsiodesWished = durationEpsiodesWished;
    }

    public Duration getDurationEpsiodesWatched() {
        return durationEpsiodesWatched;
    }

    public void setDurationEpsiodesWatched(Duration durationEpsiodesWatched) {
        this.durationEpsiodesWatched = durationEpsiodesWatched;
    }

    public Integer getNumberEpisodesWished() {
        return numberEpisodesWished;
    }

    public void setNumberEpisodesWished(Integer numberEpisodesWished) {
        this.numberEpisodesWished = numberEpisodesWished;
    }

    public Integer getNumberEpisodesWatched() {
        return numberEpisodesWatched;
    }

    public void setNumberEpisodesWatched(Integer numberEpisodesWatched) {
        this.numberEpisodesWatched = numberEpisodesWatched;
    }

    public Duration getDurationMoviesWished() {
        return durationMoviesWished;
    }

    public void setDurationMoviesWished(Duration durationMoviesWished) {
        this.durationMoviesWished = durationMoviesWished;
    }

    public Duration getDurationMoviesWatched() {
        return durationMoviesWatched;
    }

    public void setDurationMoviesWatched(Duration durationMoviesWatched) {
        this.durationMoviesWatched = durationMoviesWatched;
    }

    public Integer getNumberMoviesWished() {
        return numberMoviesWished;
    }

    public void setNumberMoviesWished(Integer numberMoviesWished) {
        this.numberMoviesWished = numberMoviesWished;
    }

    public Integer getNumberMoviesWatched() {
        return numberMoviesWatched;
    }

    public void setNumberMoviesWatched(Integer numberMoviesWatched) {
        this.numberMoviesWatched = numberMoviesWatched;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
