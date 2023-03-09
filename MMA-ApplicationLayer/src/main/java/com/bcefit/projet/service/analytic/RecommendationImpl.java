package com.bcefit.projet.service.analytic;


import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.watch.WatchEpisode;
import com.bcefit.projet.domain.watch.WatchMovie;
import com.bcefit.projet.domain.wish.WishEpisode;
import com.bcefit.projet.domain.wish.WishMovie;
import com.bcefit.projet.service.wish.IWishEpisodeService;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbTV;
import info.movito.themoviedbapi.TmdbTvSeasons;
import info.movito.themoviedbapi.model.tv.TvEpisode;
import info.movito.themoviedbapi.model.tv.TvSeason;
import info.movito.themoviedbapi.model.tv.TvSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationImpl implements IRecommendationService{

    @Autowired
    IWishEpisodeService service;


    public List<WishEpisode> createWishEpisodeByTvId(TvSeries tvSeries) {

        List<WishEpisode> wishEpisodeListTotale = new ArrayList<>();
        TmdbApi tmdb = new TmdbApi("45b46c1e742cef1725535eafeb1fba52");

        TvSeries tvResult = tmdb.getTvSeries().getSeries(tvSeries.getId(),"en", TmdbTV.TvMethod.credits ,TmdbTV.TvMethod.external_ids);

        TvSeries tvSeries1 = tmdb.getTvSeries().getSeries(tvSeries.getId(),"en", TmdbTV.TvMethod.recommendations ,TmdbTV.TvMethod.external_ids);


        List<TvSeason> tvSeasonList =tvResult.getSeasons().stream().toList();

        for(TvSeason tvSeason : tvSeasonList){

            TvEpisode episode = tmdb.getTvEpisodes().getEpisode(1396, 5, 3, "en");
            TvSeason seasonResult = tmdb.getTvSeasons().getSeason(tvResult.getId(),tvSeason.getId(),"en",TmdbTvSeasons.SeasonMethod.values());



            List<TvEpisode> tvEpisodeList = seasonResult.getEpisodes().stream().toList();

            for(TvEpisode tvEpisode : tvEpisodeList){
                WishEpisode wishEpisode = new WishEpisode();
                //wishEpisode.setIdEpisode(Long.valueOf(tvEpisode.getId()));
                //wishEpisode.setIdTv(Long.valueOf(tvSeries.getId()));
                //wishEpisode.setIdSeason(Long.valueOf(tvSeason.getId()));
                // User Account à traiter par la suite
                wishEpisode.setUserAccount(new UserAccount());
                // Appel au service de création de WishIds
                service.createWishEpisode(wishEpisode);
                wishEpisodeListTotale.add(wishEpisode);
            }
        }
        return wishEpisodeListTotale;
    }


    @Override
    public void calculRecosWatchMovie(WatchMovie watchMovie, String methode) {

    }

    @Override
    public void calculRecosWatchEpisode(WatchEpisode watchEpisode, String methode) {

    }

    @Override
    public void calculRecosWishMovie(WishMovie wishMovie, String methode) {

    }

    @Override
    public void calculRecosWishEpisode(WishEpisode wishEpisode, String methode) {

    }
}
