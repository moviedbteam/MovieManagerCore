package com.bcefit.projet.service.analytic;

import com.bcefit.projet.domain.analytic.MovieRecommendation;
import com.bcefit.projet.domain.moviedb.Movie;
import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.infrastructure.IMovieRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class IMovieRecommendationServiceImpl implements IMovieRecommendationService{

    @Autowired
    IMovieRecommendationRepository iMovieRecommendationRepository;

    @Override
    @Transactional
    public void deleteMovieRecommendation(Movie movie, UserAccount userAccount) {
        iMovieRecommendationRepository.deleteByUserAccountAndMovie(userAccount,movie);
    }

    @Override
    public MovieRecommendation findMovieRecommendationByIdMovieAndUserAccount(Movie movie, UserAccount userAccount) {
        return iMovieRecommendationRepository.findByUserAccountAndMovie(userAccount,movie);
    }

    @Override
    public void createMovieRecommendation(Movie movie, UserAccount userAccount) {
        MovieRecommendation movieRecommendation = new MovieRecommendation();
        movieRecommendation.setUserAccount(userAccount);
        movieRecommendation.setMovie(movie);
        movieRecommendation.setDate(LocalDate.now());
        iMovieRecommendationRepository.save(movieRecommendation);
    }
}
