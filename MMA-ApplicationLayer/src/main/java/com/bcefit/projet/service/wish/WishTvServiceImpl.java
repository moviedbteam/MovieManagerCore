package com.bcefit.projet.service.wish;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.wish.WishEpisode;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbTV;
import info.movito.themoviedbapi.model.tv.TvEpisode;
import info.movito.themoviedbapi.model.tv.TvSeason;
import info.movito.themoviedbapi.model.tv.TvSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishTvServiceImpl implements IWishTvService {
    @Autowired
    IWishEpisodeService service;


    public List<WishEpisode> createWishEpisodeByTvId(TvSeries tvSeries) {

        List<WishEpisode> wishEpisodeListTotale = new ArrayList<>();
        TmdbApi tmdb = new TmdbApi("45b46c1e742cef1725535eafeb1fba52");

        TvSeries tvResult = tmdb.getTvSeries().getSeries(tvSeries.getId(),"en", TmdbTV.TvMethod.credits ,TmdbTV.TvMethod.external_ids);

        // Code pour récupérer les recommendations : à garder pour le Batch
        //TvSeries tvSeries1 = tmdb.getTvSeries().getSeries(tvSeries.getId(),"en", TmdbTV.TvMethod.recommendations ,TmdbTV.TvMethod.external_ids);

        for(int i=1; i<= tvResult.getNumberOfSeasons();i++){
            TvSeason resultSeason = tmdb.getTvSeasons().getSeason(tvSeries.getId(), i, "fr");


            List<TvEpisode> tvEpisodeList = resultSeason.getEpisodes().stream().toList();


            for(TvEpisode tvEpisode : tvEpisodeList){
                WishEpisode wishEpisode = new WishEpisode();
                wishEpisode.setIdEpisode(Long.valueOf(tvEpisode.getId()));
                wishEpisode.setIdTv(Long.valueOf(tvSeries.getId()));
                wishEpisode.setIdSeason(Long.valueOf(resultSeason.getId()));
                // User Account à traiter par la suite
                UserAccount testUser = new UserAccount();
                testUser.setIdUser(1234L);
                wishEpisode.setUserAccount(testUser);
                // Appel au service de création de WishIds
                service.createWishEpisode(wishEpisode);
                wishEpisodeListTotale.add(wishEpisode);
            }
        }
        return wishEpisodeListTotale;
    }
}

