package com.bcefit.projet.domain.wish;

import com.bcefit.projet.domain.user.UserAccount;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "wish_movie")
public class WishMovie extends WishContent{

    private Long idMovie;

    private Long idCollection;


    public WishMovie(Long idWish, UserAccount userAccount, LocalDate dateWsih, Long idMovie, Long idCollection) {
        super(idWish, userAccount, dateWsih);
        this.idMovie = idMovie;
        this.idCollection = idCollection;
    }

    public WishMovie(Long idMovie, Long idCollection) {
        this.idMovie = idMovie;
        this.idCollection = idCollection;
    }

    public WishMovie(Long idWish, UserAccount userAccount) {
        super(idWish, userAccount);
    }

    public WishMovie() {
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
