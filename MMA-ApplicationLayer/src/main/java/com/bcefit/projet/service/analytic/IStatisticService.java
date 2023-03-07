package com.bcefit.projet.service.analytic;

import com.bcefit.projet.domain.watch.WatchEpisode;
import com.bcefit.projet.domain.watch.WatchMovie;
import com.bcefit.projet.domain.wish.WishEpisode;
import com.bcefit.projet.domain.wish.WishMovie;

public interface IStatisticService {

    void calculStatsWatchMovie(WatchMovie watchMovie, String methode);

    void calculStatsWatchEpisode(WatchEpisode watchEpisode, String methode);

    void calculStatsWishMovie(WishMovie wishMovie, String methode);

    void calculStatsWishEpisode(WishEpisode wishEpisode, String methode);

}
