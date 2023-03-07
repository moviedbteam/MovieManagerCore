package com.bcefit.projet.exposition.watch.dto;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.exposition.user.dto.UserAccountDto;

import java.time.Duration;
import java.time.LocalDate;

public class WatchEpisodeDto {

    private Long idWatch;


    private Long idEpisode;

    private Long idSeason;

    private Long idTv;


    private String viewingPlace;

    // Note de 1 à 5
    private Integer viewingRate;

    // Nombre associé à des humeurs :
    // 1=Choqué, 2=Frustré, 3= Triste, 4=Songeur, 5=Emu, 6=Amusé, 7= Effrayé, 8=Las, 9=Compris, 10=Ravi, 11= Perdu, 12= Tendu
    private Integer viewingMood;


    private LocalDate dateWatch;

    private Duration duration;

    public WatchEpisodeDto() {
    }

    public WatchEpisodeDto(Long idWatch, Long idEpisode, Long idSeason, Long idTv, String viewingPlace, Integer viewingRate, Integer viewingMood, LocalDate dateWatch, Duration duration) {
        this.idWatch = idWatch;
        this.idEpisode = idEpisode;
        this.idSeason = idSeason;
        this.idTv = idTv;
        this.viewingPlace = viewingPlace;
        this.viewingRate = viewingRate;
        this.viewingMood = viewingMood;
        this.dateWatch = dateWatch;
        this.duration = duration;
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


    public LocalDate getDateWatch() {
        return dateWatch;
    }

    public void setDateWatch(LocalDate dateWatch) {
        this.dateWatch = dateWatch;
    }

    public String getViewingPlace() {
        return viewingPlace;
    }

    public void setViewingPlace(String viewingPlace) {
        this.viewingPlace = viewingPlace;
    }

    public Integer getViewingRate() {
        return viewingRate;
    }

    public void setViewingRate(Integer viewingRate) {
        this.viewingRate = viewingRate;
    }

    public Integer getViewingMood() {
        return viewingMood;
    }

    public void setViewingMood(Integer viewingMood) {
        this.viewingMood = viewingMood;
    }

    public Long getIdTv() {
        return idTv;
    }

    public void setIdTv(Long idTv) {
        this.idTv = idTv;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
