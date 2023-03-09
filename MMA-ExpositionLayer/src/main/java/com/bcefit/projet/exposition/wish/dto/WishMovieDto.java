package com.bcefit.projet.exposition.wish.dto;

import com.bcefit.projet.domain.user.UserAccount;


public class WishMovieDto {

    private Long idWish;


    private Long idMovie;



    public WishMovieDto() {
    }

    public WishMovieDto(Long idWish, Long idMovie) {
        this.idWish = idWish;
        this.idMovie = idMovie;
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


}