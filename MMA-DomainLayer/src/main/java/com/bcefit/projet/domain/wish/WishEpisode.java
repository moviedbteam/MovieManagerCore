package com.bcefit.projet.domain.wish;

import com.bcefit.projet.domain.user.UserAccount;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "wish_episode")
public class WishEpisode extends WishContent{

    private Long idEpisode;

    private Long idSeason;

    private Long idTv;

    public WishEpisode(Long idWish, UserAccount userAccount, LocalDate dateWsih, Long idEpisode, Long idSeason, Long idTv) {
        super(idWish, userAccount, dateWsih);
        this.idEpisode = idEpisode;
        this.idSeason = idSeason;
        this.idTv = idTv;
    }

    public WishEpisode(Long idEpisode, Long idSeason, Long idTv) {
        this.idEpisode = idEpisode;
        this.idSeason = idSeason;
        this.idTv = idTv;
    }

    public WishEpisode() {

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
