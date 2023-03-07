package com.bcefit.projet.service.analytic;

import com.bcefit.projet.domain.watch.WatchEpisode;
import com.bcefit.projet.domain.watch.WatchMovie;

public interface IAnalyticService {

    void addWatchMovieAnalytic(WatchMovie watchMovie);


    void addWatchEpisodeAnalytic(WatchEpisode watchEpisode);


}
