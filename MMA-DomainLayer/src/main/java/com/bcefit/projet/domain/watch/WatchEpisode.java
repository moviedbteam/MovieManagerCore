package com.bcefit.projet.domain.watch;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.watch.WatchContent;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "watch_episode")
public class WatchEpisode extends WatchContent {

    private Long idEpisode;

    private Long idSeason;

    private Long idTv;


    public WatchEpisode(Long idWatch, UserAccount userAccount, Long idEpisode, Long idSeason, Long idTv) {
        super(idWatch, userAccount);
        this.idEpisode = idEpisode;
        this.idSeason = idSeason;
        this.idTv = idTv;
    }

    public WatchEpisode(Long idEpisode, Long idSeason, Long idTv) {
        this.idEpisode = idEpisode;
        this.idSeason = idSeason;
        this.idTv = idTv;
    }

    public WatchEpisode() {

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
        return idTv;
    }

    public void setIdTv(Long idTv) {
        this.idTv = idTv;
    }
}
