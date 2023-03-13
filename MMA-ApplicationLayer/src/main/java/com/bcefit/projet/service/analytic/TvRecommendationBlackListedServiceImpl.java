package com.bcefit.projet.service.analytic;

import com.bcefit.projet.domain.analytic.TvRecommendationBlackListed;
import com.bcefit.projet.domain.moviedb.Tv;
import com.bcefit.projet.infrastructure.ITvRecommendationBlackListedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TvRecommendationBlackListedServiceImpl implements ITvRecommendationBlackListedService {

    @Autowired
    ITvRecommendationBlackListedRepository iTvRecommendationBlackListedRepository;


    @Override
    public TvRecommendationBlackListed isBlackListedByTv(Tv tv) {
        return iTvRecommendationBlackListedRepository.findByTv(tv);
    }

    @Override
    public void createTvRecommandationBlackListed(TvRecommendationBlackListed tvRecommendationBlackListed) {
        tvRecommendationBlackListed.setDate(LocalDate.now());
        iTvRecommendationBlackListedRepository.save(tvRecommendationBlackListed);
    }
}
