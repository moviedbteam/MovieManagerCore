package com.bcefit.projet.exposition.watch.dto;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.exposition.user.dto.UserAccountDto;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.util.Date;

public class WatchMovieDto {

    private Long idWatch;

    private UserAccountDto userAccountDto;

    private String viewingPlace;

    // Note de 1 à 5
    private Integer viewingRate;

    // Nombre associé à des humeurs :
    // 1=Choqué, 2=Frustré, 3= Triste, 4=Songeur, 5=Emu, 6=Amusé, 7= Effrayé, 8=Las, 9=Compris, 10=Ravi, 11= Perdu, 12= Tendu
    private Integer viewingMood;

    private Integer idMovie;

    private Integer idCollection;

    private LocalDate dateWatch;

    public WatchMovieDto() {
    }

    public WatchMovieDto(Long idWatch, UserAccountDto userAccountDto, String viewingPlace, Integer viewingRate, Integer viewingMood, Integer idMovie, Integer idCollection, LocalDate dateWatch) {
        this.idWatch = idWatch;
        this.userAccountDto = userAccountDto;
        this.viewingPlace = viewingPlace;
        this.viewingRate = viewingRate;
        this.viewingMood = viewingMood;
        this.idMovie = idMovie;
        this.idCollection = idCollection;
        this.dateWatch = dateWatch;
    }

    public Long getIdWatch() {
        return idWatch;
    }

    public void setIdWatch(Long idWatch) {
        this.idWatch = idWatch;
    }


    public Integer getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
    }

    public Integer getIdCollection() {
        return idCollection;
    }

    public void setIdCollection(Integer idCollection) {
        this.idCollection = idCollection;
    }

    public UserAccountDto getUserAccountDto() {
        return userAccountDto;
    }

    public void setUserAccountDto(UserAccountDto userAccountDto) {
        this.userAccountDto = userAccountDto;
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
}
