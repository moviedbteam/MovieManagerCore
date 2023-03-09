package com.bcefit.projet.service.moviedb.api;

import com.bcefit.projet.domain.analytic.MovieRecommendation;
import com.bcefit.projet.domain.moviedb.Movie;
import com.bcefit.projet.domain.moviedb.Tv;
import com.bcefit.projet.domain.watch.WatchEpisode;
import com.bcefit.projet.domain.wish.WishEpisode;

import java.util.List;

public interface ITmdbApiService {


    Movie synchronizeMovieDetailFromApi(Integer idMovie);
    Tv synchronizeTvDetailFromApiFromApi(Integer idTv);

    /*
    List<WishEpisode> getWishEpisodeListByIdTvFromApi(Integer idTv);


    List<WishEpisode> getWishEpisodeListByIdSeasonFromApi(Integer idTv, Integer numberSeason);

    List<WatchEpisode> getWatchEpisodeListByIdTvFromApi(Integer idTv);


    List<WatchEpisode> getWatchEpisodeListByIdSeasonFromApi(Integer idTv, Integer numberSeason);

    Integer getEpisodeDetailFromApi(Integer idTv);





    Integer getEpisodeDetailFromApiFromApi(Integer idTv);

    List<MovieRecommendation> getMovieRecommendationsFromApi(Integer idMovie);


     */
}