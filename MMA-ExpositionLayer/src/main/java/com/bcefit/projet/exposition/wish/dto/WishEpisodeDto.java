package com.bcefit.projet.exposition.wish.dto;

import com.bcefit.projet.domain.user.UserAccount;

public class WishEpisodeDto {

    private Long idWish;


    private Long idEpisode;

    private Long idSeason;

    private int seasonNumber;

    private Long IdTv;

    public WishEpisodeDto() {
    }

    public WishEpisodeDto(Long idWish, Long idEpisode, Long idSeason, int seasonNumber, Long idTv) {
        this.idWish = idWish;
        this.idEpisode = idEpisode;
        this.idSeason = idSeason;
        this.seasonNumber = seasonNumber;
        IdTv = idTv;
    }

    public Long getIdWish() {
        return idWish;
    }

    public void setIdWish(Long idWish) {
        this.idWish = idWish;
    }

    public Long getIdEpisode() {
        return idEpisode;
    }

    public void setIdEpisode(Long idEpisode) {
        this.idEpisode = idEpisode;
    }

    public Long getIdSeason() {
        return idSeason;
    }

    public void setIdSeason(Long idSeason) {
        this.idSeason = idSeason;
    }

    public Long getIdTv() {
        return IdTv;
    }

    public void setIdTv(Long idTv) {
        IdTv = idTv;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
}
