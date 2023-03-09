package com.bcefit.projet.infrastructure;

import com.bcefit.projet.domain.watch.WatchMovie;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;


public interface IWatchMovieRepository extends CrudRepository<WatchMovie, Long> {
    /*
    @Transactional
    @Modifying
    @Query("update WatchMovie w set w.duration = ?1 where w.idWatch = ?2")
    void updateDurationbyWatchMovie(Duration duration, Long idWatch);
    */
}
