package com.bcefit.projet.exposition.watch.dto;

import com.bcefit.projet.domain.user.UserAccount;

import java.time.LocalDate;
import java.util.Date;

public class WatchEpisodeDto {

    private Long idWatch;

    private UserAccount userAccount;

    private Long idEpisode;

    private Long idSeason;

    private Long IdTv;

    private LocalDate dateWatch;

    public WatchEpisodeDto() {
    }

    public WatchEpisodeDto(Long idWatch, UserAccount userAccount, Long idEpisode, Long idSeason, Long idTv, LocalDate dateWatch) {
        this.idWatch = idWatch;
        this.userAccount = userAccount;
        this.idEpisode = idEpisode;
        this.idSeason = idSeason;
        IdTv = idTv;
        this.dateWatch = dateWatch;
    }

    public Long getIdWatch() {
        return idWatch;
    }

    public void setIdWatch(Long idWatch) {
        this.idWatch = idWatch;
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

    public LocalDate getDateWatch() {
        return dateWatch;
    }

    public void setDateWatch(LocalDate dateWatch) {
        this.dateWatch = dateWatch;
    }
}
