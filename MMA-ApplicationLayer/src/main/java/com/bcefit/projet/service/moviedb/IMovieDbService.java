package com.bcefit.projet.service.moviedb;

import com.bcefit.projet.domain.analytic.MovieRecommendation;
import com.bcefit.projet.domain.watch.WatchEpisode;
import com.bcefit.projet.domain.wish.WishEpisode;

import java.util.List;

public interface IMovieDbService {

    List<WishEpisode> getWishEpisodeListByIdTv(Integer idTv);


    List<WishEpisode> getWishEpisodeListByIdSeason(Integer idTv, Integer numberSeason);

    List<WatchEpisode> getWatchEpisodeListByIdTv(Integer idTv);


    List<WatchEpisode> getWatchEpisodeListByIdSeason(Integer idTv, Integer numberSeason);

    Integer getMovieDetail(Integer idMovie);

    Integer getEpisodeDetail(Integer idTv);

    List<MovieRecommendation> getMovieRecommendations(Integer idMovie);
}
