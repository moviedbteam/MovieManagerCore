package com.bcefit.projet.service.moviedb.api;


import com.bcefit.projet.domain.moviedb.Episode;
import com.bcefit.projet.domain.moviedb.Movie;
import com.bcefit.projet.domain.moviedb.Season;
import com.bcefit.projet.domain.moviedb.Tv;
import com.bcefit.projet.infrastructure.IEpisodeRepository;
import com.bcefit.projet.infrastructure.IMovieRepository;
import com.bcefit.projet.infrastructure.ISeasonRepository;
import com.bcefit.projet.infrastructure.ITvRepository;
import com.bcefit.projet.service.mapper.EpisodeApiMapper;
import com.bcefit.projet.service.mapper.MovieApiMapper;
import com.bcefit.projet.service.mapper.SeasonApiMapper;
import com.bcefit.projet.service.mapper.TvApiMapper;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbTV;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.tv.TvEpisode;
import info.movito.themoviedbapi.model.tv.TvSeason;
import info.movito.themoviedbapi.model.tv.TvSeries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ITmdbApiServiceImpl implements ITmdbApiService {

    @Autowired
    MovieApiMapper movieApiMapper;
    @Autowired
    TvApiMapper tvApiMapper;
    @Autowired
    SeasonApiMapper seasonApiMapper;
    @Autowired
    EpisodeApiMapper episodeApiMapper;

    @Autowired
    IMovieRepository iMovieRepository;
    @Autowired
    ITvRepository iTvRepository;
    @Autowired
    ISeasonRepository iSeasonRepository;
    @Autowired
    IEpisodeRepository iEpisodeRepository;

    Logger logger = LoggerFactory.getLogger(ITmdbApiServiceImpl.class);

    private TmdbApi getSessionApi() {
        TmdbApi tmdb = new TmdbApi("45b46c1e742cef1725535eafeb1fba52");
        return tmdb;
    }

    @Override
    public Movie synchronizeMovieDetailFromApi(Long idMovie) {
        //Création des variables qui seront utilisées pour la synchronisation
        Movie tmptv = new Movie();
        TmdbApi tmdb = getSessionApi();

        // Contrôle dans la base local si le Movie est présent
        Movie movieLocal = iMovieRepository.findByIdMovie(idMovie);

        if ((movieLocal == null)) {

            // récupération du Movie et synchronisation en base
            MovieDb movieDb = tmdb.getMovies().getMovie(idMovie.intValue(), "fr", TmdbMovies.MovieMethod.credits);
            tmptv = movieApiMapper.convertMovieApiToMovie(movieDb);
            iMovieRepository.save(tmptv);
            return tmptv;
        }else {
            return movieLocal;
        }
    }

    @Override
    public Tv synchronizeTvDetailFromApiFromApi(Long idTv) {
        //Création des variables qui seront utilisées pour la synchronisation
        Tv tmptv = new Tv();
        List<Season> seasonList = new ArrayList<>();
        List<Episode> episodeList = new ArrayList<>();

        // récupération de la série Tv et synchronisation en base
        TmdbApi tmdb = getSessionApi();
        TvSeries tvSeries = tmdb.getTvSeries().getSeries(idTv.intValue(), "fr");
        tmptv = tvApiMapper.convertTvApiToTv(tvSeries);

        // Contrôle dans la base local si la série est présente et si le nombre d'épisodes à évolué
        Tv tvLocal = iTvRepository.findByIdTv(idTv);

        if ((tvLocal == null) || (tvLocal.getNumberOfEpisodes()!=tmptv.getNumberOfEpisodes())){

            iTvRepository.save(tmptv);

            List<TvSeason> tvSeasonList = tvSeries.getSeasons();

            for (TvSeason tvSeason : tvSeasonList) {
                // récupération des saisons et synchronisation en base

                TvSeason tmpTvSeason = tmdb.getTvSeasons().getSeason(tvSeries.getId(), tvSeason.getSeasonNumber(), "fr");

                if(tmpTvSeason!=null){
                    Season tmpSeason = new Season();
                    tmpSeason = seasonApiMapper.convertSeasonApiToSeason(tmpTvSeason);
                    tmpSeason.setTv(tmptv);
                    iSeasonRepository.save(tmpSeason);

                    // récupération des episodes et synchronisation en base
                    List<TvEpisode> tvEpisodeList = tmpTvSeason.getEpisodes().stream().toList();
                    if (tvEpisodeList != null) {
                        for (TvEpisode tvEpisode : tvEpisodeList) {
                            Episode tmpEpisode = episodeApiMapper.convertEpisodeApiToEpisode(tvEpisode);
                            tmpEpisode.setSeason(seasonApiMapper.convertSeasonApiToSeason(tvSeason));
                            tmpEpisode.setSeason(tmpSeason);
                            episodeList.add(tmpEpisode);

                            iEpisodeRepository.save(tmpEpisode);
                        }
                    }
                    seasonList.add(tmpSeason);
                }
            }
            tmptv.setSeasons(seasonList);
            return tmptv;
        }
    return tvLocal;
    }

    @Override
    public List<Movie> getAllMovieRecommendation(Long idMovie) {
        //Création des variables qui seront utilisées pour la récupération des recommendations
        List<Movie> movieList = new ArrayList<>();
        TmdbApi tmdb = getSessionApi();

        // récupération des recommendations associées au Movie
        MovieDb movieDb = tmdb.getMovies().getMovie(idMovie.intValue(), "fr", TmdbMovies.MovieMethod.recommendations);
        movieList = movieApiMapper.convertListMovieRecommendationApiToMovie(movieDb.getRecommendations());
        return movieList;
    }

    @Override
    public List<Tv> getAllTvRecommendation(Long idTv) {
        //Création des variables qui seront utilisées pour la récupération des recommendations
        List<Tv> tvList = new ArrayList<>();
        TmdbApi tmdb = getSessionApi();

        // récupération des recommendations associées au Tv
        TvSeries tvSeries = tmdb.getTvSeries().getSeries(idTv.intValue(),"fr", TmdbTV.TvMethod.recommendations);
        tvList = tvApiMapper.convertTvRecommendationApiToTv(tvSeries.getRecommendations().getResults());
        return tvList;
    }
}
