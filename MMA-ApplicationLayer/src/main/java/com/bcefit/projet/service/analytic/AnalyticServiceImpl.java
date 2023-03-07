package com.bcefit.projet.service.analytic;

import com.bcefit.projet.domain.watch.WatchEpisode;
import com.bcefit.projet.domain.watch.WatchMovie;
import com.bcefit.projet.service.moviedb.IMovieDbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyticServiceImpl implements IAnalyticService{

    @Autowired
    IMovieDbServiceImpl iMovieDbService;

    @Override
    public void addWatchMovieAnalytic(WatchMovie watchMovie) {
        iMovieDbService.getMovieDetail(watchMovie.getIdMovie().intValue());
    }

    @Override
    public void delWatchMovieAnalytic(WatchMovie watchMovie) {

    }

    @Override
    public void addWatchEpisodeAnalytic(WatchEpisode watchEpisode) {

    }

    @Override
    public void delWatchEpisodeAnalytic(WatchEpisode watchEpisode) {

    }
}
