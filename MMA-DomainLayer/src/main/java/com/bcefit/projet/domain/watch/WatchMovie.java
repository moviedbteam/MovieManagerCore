package com.bcefit.projet.domain.watch;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.watch.WatchContent;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "watch_movie")
public class WatchMovie extends WatchContent {

    private Integer idMovie;

    private Integer idCollection;


    public WatchMovie(Long idWatch, UserAccount userAccount, Integer idMovie, Integer idCollection) {
        super(idWatch, userAccount);
        this.idMovie = idMovie;
        this.idCollection = idCollection;
    }

    public WatchMovie() {

    }

    public Integer getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
    }

    public Integer getIdCollection() {
        return idCollection;
    }

    public void setIdCollection(Integer idCollection) {
        this.idCollection = idCollection;
    }
}
