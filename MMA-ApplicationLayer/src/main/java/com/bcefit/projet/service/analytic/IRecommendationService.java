package com.bcefit.projet.service.analytic;

import com.bcefit.projet.domain.watch.WatchEpisode;
import com.bcefit.projet.domain.watch.WatchMovie;
import com.bcefit.projet.domain.wish.WishEpisode;
import com.bcefit.projet.domain.wish.WishMovie;

public interface IRecommendationService {

    void calculRecosWatchMovie(WatchMovie watchMovie, String methode);

    void calculRecosWatchEpisode(WatchEpisode watchEpisode, String methode);

    void calculRecosWishMovie(WishMovie wishMovie, String methode);

    void calculRecosWishEpisode(WishEpisode wishEpisode, String methode);
}
