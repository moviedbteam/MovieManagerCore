package com.bcefit.projet.service.analytic;

import com.bcefit.projet.domain.analytic.TvRecommendation;
import com.bcefit.projet.domain.moviedb.Tv;
import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.infrastructure.ITvRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class TvRecommendationServiceImpl implements ITvRecommendationService{

    @Autowired
    ITvRecommendationRepository iTvRecommendationRepository;

    @Override
    @Transactional
    public void deleteTvRecommendation(Tv tv, UserAccount userAccount) {
        iTvRecommendationRepository.deleteByUserAccountAndTv(userAccount,tv);

    }

    @Override
    public TvRecommendation findTvRecommendationByIdTvAndUserAccount(Tv tv, UserAccount userAccount) {
        return iTvRecommendationRepository.findByUserAccountAndTv(userAccount,tv);
    }

    @Override
    public void createTvRecommendation(Tv tv, UserAccount userAccount) {
        TvRecommendation tvRecommendation = new TvRecommendation();
        tvRecommendation.setUserAccount(userAccount);
        tvRecommendation.setTv(tv);
        tvRecommendation.setDate(LocalDate.now());
        iTvRecommendationRepository.save(tvRecommendation);
    }
}
