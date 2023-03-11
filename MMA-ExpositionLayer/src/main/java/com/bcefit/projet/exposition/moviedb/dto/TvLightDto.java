package com.bcefit.projet.exposition.moviedb.dto;

import com.bcefit.projet.domain.moviedb.GenreTv;
import com.bcefit.projet.domain.moviedb.Season;
import com.bcefit.projet.domain.moviedb.StreamingSubscription;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TvLightDto {
    private Long idTv;
   private String originalName;
    private String posterPath;
    private int numberOfEpisodes;
    private int numberOfSeasons;

    private Long idWatch;
    private String viewingPlace;
    // Note de 1 à 5
    private Integer viewingRate;
    // Nombre associé à des humeurs :
    // 1=Choqué, 2=Frustré, 3= Triste, 4=Songeur, 5=Emu, 6=Amusé, 7= Effrayé, 8=Las, 9=Compris, 10=Ravi, 11= Perdu, 12= Tendu
    private Integer viewingMood;
    private LocalDate dateWatch;

    private Long idWish;

    public TvLightDto() {
    }

    public TvLightDto(Long idTv, String originalName, String posterPath, int numberOfEpisodes, int numberOfSeasons, Long idWatch, String viewingPlace, Integer viewingRate, Integer viewingMood, LocalDate dateWatch, Long idWish) {
        this.idTv = idTv;
        this.originalName = originalName;
        this.posterPath = posterPath;
        this.numberOfEpisodes = numberOfEpisodes;
        this.numberOfSeasons = numberOfSeasons;
        this.idWatch = idWatch;
        this.viewingPlace = viewingPlace;
        this.viewingRate = viewingRate;
        this.viewingMood = viewingMood;
        this.dateWatch = dateWatch;
        this.idWish = idWish;
    }

    public Long getIdTv() {
        return idTv;
    }

    public void setIdTv(Long idTv) {
        this.idTv = idTv;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public Long getIdWatch() {
        return idWatch;
    }

    public void setIdWatch(Long idWatch) {
        this.idWatch = idWatch;
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

    public LocalDate getDateWatch() {
        return dateWatch;
    }

    public void setDateWatch(LocalDate dateWatch) {
        this.dateWatch = dateWatch;
    }

    public Long getIdWish() {
        return idWish;
    }

    public void setIdWish(Long idWish) {
        this.idWish = idWish;
    }
}
