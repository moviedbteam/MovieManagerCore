package com.bcefit.projet.service.analytic;

import com.bcefit.projet.domain.analytic.MovieRecommendationBlackListed;
import com.bcefit.projet.domain.moviedb.Movie;
import com.bcefit.projet.domain.moviedb.Tv;
import com.bcefit.projet.infrastructure.IMovieRecommendationBlackListedRepository;
import com.bcefit.projet.infrastructure.ITvRecommendationBlackListedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MovieRecommendationBlackListedServiceImpl implements IMovieRecommendationBlackListedService{

    @Autowired
    IMovieRecommendationBlackListedRepository iMovieRecommendationBlackListedRepository;

    @Override
    public MovieRecommendationBlackListed isBlackListedByMovie(Movie movie) {
        return iMovieRecommendationBlackListedRepository.findByMovie(movie);
    }

    @Override
    public void createMovieRecommandationBlackListed(MovieRecommendationBlackListed movieRecommendationBlackListed) {
        movieRecommendationBlackListed.setDate(LocalDate.now());
        iMovieRecommendationBlackListedRepository.save(movieRecommendationBlackListed);
    }
}
