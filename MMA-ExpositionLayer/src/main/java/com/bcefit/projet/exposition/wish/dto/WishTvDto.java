package com.bcefit.projet.exposition.wish.dto;

public class WishTvDto {

    private Long idTv;

    public WishTvDto(Long idTv) {
        this.idTv = idTv;
    }

    public WishTvDto() {
    }

    public Long getIdTv() {
        return idTv;
    }

    public void setIdTv(Long idTv) {
        this.idTv = idTv;
    }
}
