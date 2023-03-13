package com.bcefit.projet.service.analytic;

import com.bcefit.projet.domain.moviedb.Movie;
import com.bcefit.projet.domain.moviedb.Tv;
import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.watch.WatchEpisode;
import com.bcefit.projet.domain.watch.WatchMovie;

public interface IAnalyticService {


    void addWatchMovieAnalytic(Movie movie, UserAccount userAccount);

    void deleteWatchMovieAnalytic(Movie movie, UserAccount userAccount);

    void addWatchTvAnalytic(Tv tv, UserAccount userAccount);

    void deleteWatchTvAnalytic(Tv tv, UserAccount userAccount);

    void addWishMovieAnalytic(Movie movie, UserAccount userAccount);

    void deleteWishMovieAnalytic(Movie movie, UserAccount userAccount);

    void addWishTvAnalytic(Tv tv, UserAccount userAccount);

    void deleteWishTvAnalytic(Tv tv, UserAccount userAccount);
}
