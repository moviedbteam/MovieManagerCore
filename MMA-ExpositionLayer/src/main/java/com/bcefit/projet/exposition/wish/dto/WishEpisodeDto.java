package com.bcefit.projet.exposition.wish.dto;

import com.bcefit.projet.domain.user.UserAccount;

public class WishEpisodeDto {

    private Long idWish;

    private UserAccount userAccount;

    private Long idEpisode;

    private Long idSeason;

    private Long IdTv;

    public WishEpisodeDto() {
    }

    public WishEpisodeDto(Long idWish, UserAccount userAccount, Long idEpisode, Long idSeason, Long idTv) {
        this.idWish = idWish;
        this.userAccount = userAccount;
        this.idEpisode = idEpisode;
        this.idSeason = idSeason;
        IdTv = idTv;
    }

    public Long getIdWish() {
        return idWish;
    }

    public void setIdWish(Long idWish) {
        this.idWish = idWish;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
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
}
