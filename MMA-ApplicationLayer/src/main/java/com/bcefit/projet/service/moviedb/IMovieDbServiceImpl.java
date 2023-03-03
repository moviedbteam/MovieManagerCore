package com.bcefit.projet.service.moviedb;

import com.bcefit.projet.domain.wish.WishEpisode;
import com.bcefit.projet.service.wish.WishEpisodeServiceImpl;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbTV;
import info.movito.themoviedbapi.model.tv.TvEpisode;
import info.movito.themoviedbapi.model.tv.TvSeason;
import info.movito.themoviedbapi.model.tv.TvSeries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class IMovieDbServiceImpl implements IMovieDbService {

    Logger logger = LoggerFactory.getLogger(IMovieDbServiceImpl.class);

    private TmdbApi getSessionApi() {
        TmdbApi tmdb = new TmdbApi("45b46c1e742cef1725535eafeb1fba52");
        return tmdb;
    }

    @Override
    public List<WishEpisode> getWishEpisodeListByIdTv(Integer idTv) {

        TmdbApi tmdb = getSessionApi();

        List<WishEpisode> wishEpisodeList = new ArrayList<>();

        TvSeries tvSeries = new TvSeries();
        tvSeries.setId(idTv);

        TvSeries tvResult = tmdb.getTvSeries().getSeries(tvSeries.getId(), "en", TmdbTV.TvMethod.credits, TmdbTV.TvMethod.external_ids);

        for (int i = 1; i <= tvResult.getNumberOfSeasons(); i++) {

            TvSeason resultSeason = tmdb.getTvSeasons().getSeason(tvSeries.getId(), i, "fr");

            List<TvEpisode> tvEpisodeList = resultSeason.getEpisodes().stream().toList();


            for (TvEpisode tvEpisode : tvEpisodeList) {
                WishEpisode wishEpisode = new WishEpisode();
                wishEpisode.setIdEpisode(Long.valueOf(tvEpisode.getId()));
                wishEpisode.setIdTv(Long.valueOf(tvSeries.getId()));
                wishEpisode.setIdSeason(Long.valueOf(resultSeason.getId()));
                wishEpisodeList.add(wishEpisode);
            }
        }

        return wishEpisodeList;
    }


    @Override
    public List<WishEpisode> getWishEpisodeListByIdSeason(Integer idTv, Integer idSeason) {
        TmdbApi tmdb = getSessionApi();

        List<WishEpisode> wishEpisodeList = new ArrayList<>();
        TvSeries tvResult = tmdb.getTvSeries().getSeries(idTv, "en", TmdbTV.TvMethod.credits, TmdbTV.TvMethod.external_ids);

        List<TvSeason> tvSeasonList = tvResult.getSeasons();

        for (TvSeason tvSeason : tvSeasonList) {
            if (tvSeason.getId() == idSeason) {
                TvSeason resultSeason = tmdb.getTvSeasons().getSeason(idTv, tvSeason.getSeasonNumber(), "fr");

                List<TvEpisode> tvEpisodeList = resultSeason.getEpisodes().stream().toList();


                for (TvEpisode tvEpisode : tvEpisodeList) {
                    WishEpisode wishEpisode = new WishEpisode();
                    wishEpisode.setIdEpisode(Long.valueOf(tvEpisode.getId()));
                    wishEpisode.setIdTv(Long.valueOf(idTv));
                    wishEpisode.setIdSeason(Long.valueOf(resultSeason.getId()));
                    wishEpisodeList.add(wishEpisode);
                }
            }
        }
        return wishEpisodeList;
    }
}

        // Code pour récupérer les recommendations : à garder pour le Batch
        //TvSeries tvSeries1 = tmdb.getTvSeries().getSeries(tvSeries.getId(),"en", TmdbTV.TvMethod.recommendations ,TmdbTV.TvMethod.external_ids);

