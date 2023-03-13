package com.bcefit.projet.service.moviedb.api;

import com.bcefit.projet.domain.analytic.MovieRecommendation;
import com.bcefit.projet.domain.moviedb.Movie;
import com.bcefit.projet.domain.moviedb.Tv;
import com.bcefit.projet.domain.watch.WatchEpisode;
import com.bcefit.projet.domain.wish.WishEpisode;

import java.util.List;

public interface ITmdbApiService {


    Movie synchronizeMovieDetailFromApi(Long idMovie);
    Tv synchronizeTvDetailFromApiFromApi(Long idTv);
    List<Movie> getAllMovieRecommendation(Long idMovie);
    List<Tv> getAllTvRecommendation(Long idTv);
}