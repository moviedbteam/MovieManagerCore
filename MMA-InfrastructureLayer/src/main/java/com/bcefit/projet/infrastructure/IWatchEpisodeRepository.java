package com.bcefit.projet.infrastructure;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.watch.WatchEpisode;
import com.bcefit.projet.domain.watch.WatchMovie;
import com.bcefit.projet.domain.wish.WishEpisode;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public interface IWatchEpisodeRepository extends CrudRepository<WatchEpisode, Long> {

    /*
    @Transactional
    @Modifying
    @Query("update WatchEpisode w set w.duration = ?1 where w.idWatch = ?2")
    void updateDurationbyWatchEpisode(Duration duration, Long idWatch);


     */
    @Query("select w from WatchEpisode w where w.episode.idEpisode = ?1 and w.userAccount = ?2")
    WatchEpisode findByIdEpisodeAndUserAccount(Long idEpisode, UserAccount userAccount);

}
