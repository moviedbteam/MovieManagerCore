package com.bcefit.projet.domain.watch;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.watch.WatchContent;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "watch_movie")
public class WatchMovie extends WatchContent {

    private Long idMovie;

    private Long idCollection;


    public WatchMovie(Long idWatch, UserAccount userAccount, Long idMovie, Long idCollection) {
        super(idWatch, userAccount);
        this.idMovie = idMovie;
        this.idCollection = idCollection;
    }

    public WatchMovie() {

    }

    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    public Long getIdCollection() {
        return idCollection;
    }

    public void setIdCollection(Long idCollection) {
        this.idCollection = idCollection;
    }
}
