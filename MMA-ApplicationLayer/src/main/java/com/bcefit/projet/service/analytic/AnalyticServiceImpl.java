package com.bcefit.projet.service.analytic;

import com.bcefit.projet.domain.watch.WatchEpisode;
import com.bcefit.projet.domain.watch.WatchMovie;
import com.bcefit.projet.infrastructure.IWatchEpisodeRepository;
import com.bcefit.projet.infrastructure.IWatchMovieRepository;
import com.bcefit.projet.service.moviedb.IMovieDbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class AnalyticServiceImpl implements IAnalyticService{

    @Autowired
    IMovieDbServiceImpl iMovieDbService;

    @Autowired
    IWatchMovieRepository iWatchMovieRepository;
    @Autowired
    private IWatchEpisodeRepository iWatchEpisodeRepository;

    @Override
    public void addWatchMovieAnalytic(WatchMovie watchMovie) {
        // Récupération de la durée du movie et mise à jour
        Duration duration = Duration.ofMinutes(iMovieDbService.getMovieDetail(watchMovie.getIdMovie().intValue()));
        iWatchMovieRepository.updateDurationbyWatchMovie(duration, watchMovie.getIdWatch());
        // Récupérarion des données TMDB et génération des recommendations

    }

    @Override
    public void addWatchEpisodeAnalytic(WatchEpisode watchEpisode) {
        // Récupération de la durée du movie et mise à jour
        Duration duration = Duration.ofMinutes(iMovieDbService.getEpisodeDetail(watchEpisode.getIdTv().intValue()));
        iWatchEpisodeRepository.updateDurationbyWatchEpisode(duration, watchEpisode.getIdWatch());
        // Récupérarion des données TMDB et génération des recommendations

    }

}
