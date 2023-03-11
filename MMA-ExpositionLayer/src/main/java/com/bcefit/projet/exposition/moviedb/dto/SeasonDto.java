package com.bcefit.projet.exposition.moviedb.dto;

import com.bcefit.projet.domain.moviedb.Episode;
import com.bcefit.projet.domain.moviedb.Tv;

import javax.persistence.*;
import java.util.List;

public class SeasonDto {
    private Long idSeason;
    private String airDate;
    private String posterPath;
    private int seasonNumber;
    private String overview;
    private List<EpisodeDto> episodeDtoList;

    public SeasonDto() {
    }

    public SeasonDto(Long idSeason, String airDate, String posterPath, int seasonNumber, String overview, List<EpisodeDto> episodeDtoList) {
        this.idSeason = idSeason;
        this.airDate = airDate;
        this.posterPath = posterPath;
        this.seasonNumber = seasonNumber;
        this.overview = overview;
        this.episodeDtoList = episodeDtoList;
    }

    public Long getIdSeason() {
        return idSeason;
    }

    public void setIdSeason(Long idSeason) {
        this.idSeason = idSeason;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public List<EpisodeDto> getEpisodeDtoList() {
        return episodeDtoList;
    }

    public void setEpisodeDtoList(List<EpisodeDto> episodeDtoList) {
        this.episodeDtoList = episodeDtoList;
    }
}
