package com.bcefit.projet.exposition.wish.dto;

import com.bcefit.projet.domain.user.UserAccount;


public class WishMovieDto {

    private Long idWish;

    private UserAccount userAccount;

    private Long idMovie;

    private Long idCollection;

    public WishMovieDto() {
    }

    public WishMovieDto(Long idWish, UserAccount userAccount, Long idMovie, Long idCollection) {
        this.idWish = idWish;
        this.userAccount = userAccount;
        this.idMovie = idMovie;
        this.idCollection = idCollection;
    }

    public Long getIdWish() {
        return idWish;
    }

    public void setIdWish(Long idWish) {
        this.idWish = idWish;
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

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
