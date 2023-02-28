package com.bcefit.projet.exposition.watch.dto;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.exposition.user.dto.UserAccountDto;

import java.time.LocalDate;

public class WatchEpisodeDto {

    private Long idWatch;

    private Long idUser;

    private Long idEpisode;

    private Long idSeason;

    private Long IdTv;

    private LocalDate dateWatch;

    public WatchEpisodeDto() {
    }

    public WatchEpisodeDto(Long idWatch, Long idUser, Long idEpisode, Long idSeason, Long idTv, LocalDate dateWatch) {
        this.idWatch = idWatch;
        this.idUser = idUser;
        this.idEpisode = idEpisode;
        this.idSeason = idSeason;
        this.IdTv = idTv;
        this.dateWatch = dateWatch;
    }

    public Long getIdWatch() {
        return idWatch;
    }

    public void setIdWatch(Long idWatch) {
        this.idWatch = idWatch;
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

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
