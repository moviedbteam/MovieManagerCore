package com.bcefit.projet.service.mapper;


import com.bcefit.projet.domain.moviedb.Movie;
import info.movito.themoviedbapi.model.MovieDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieApiMapper {

    @Autowired
    GenreMovieApiMapper genreMovieMapper;

    public Movie convertMovieApiToMovie(MovieDb api){
        Movie entity = new Movie();
        entity.setIdMovie(Long.valueOf(api.getId()));
        entity.setTitle(api.getTitle());
        entity.setOriginalTitle(api.getOriginalTitle());
        entity.setPopularity(api.getPopularity());
        entity.setBackdropPath(api.getBackdropPath());
        entity.setPosterPath(api.getPosterPath());
        entity.setReleaseDate(api.getReleaseDate());
        entity.setAdult(api.isAdult());
        entity.setBudget(api.getBudget());
        entity.setHomepage(api.getHomepage());
        entity.setOverview(api.getOverview());
        entity.setImdbID(api.getImdbID());
        entity.setOriginalLanguage(api.getOriginalLanguage());
        entity.setRuntime(api.getRuntime());
        entity.setTagline(api.getTagline());
        entity.setVoteAverage(api.getVoteAverage());
        entity.setVoteCount(api.getVoteCount());
        entity.setStatus(api.getStatus());
        entity.setGenreMovieList(genreMovieMapper.convertListApiToEntity(api.getGenres()));
        return entity;
    }

    public MovieDb convertMovieToMovieApi(Movie entity){
        MovieDb api = new MovieDb();
        api.setId(entity.getIdMovie().intValue());
        api.setTitle(entity.getTitle());
        api.setOriginalTitle(entity.getOriginalTitle());
        api.setPopularity(entity.getPopularity());
        api.setBackdropPath(entity.getBackdropPath());
        api.setPosterPath(entity.getPosterPath());
        api.setReleaseDate(entity.getReleaseDate());
        api.setAdult(entity.isAdult());
        api.setBudget(entity.getBudget());
        api.setHomepage(entity.getHomepage());
        api.setOverview(entity.getOverview());
        api.setImdbID(entity.getImdbID());
        api.setOriginalLanguage(entity.getOriginalLanguage());
        api.setRuntime(entity.getRuntime());
        api.setTagline(entity.getTagline());
        api.setVoteAverage(entity.getVoteAverage());
        api.setVoteCount(entity.getVoteCount());
        api.setStatus(entity.getStatus());
        api.setGenres(genreMovieMapper.convertListEntityToApi(entity.getGenreMovieList()));
        return api;
    }
}
