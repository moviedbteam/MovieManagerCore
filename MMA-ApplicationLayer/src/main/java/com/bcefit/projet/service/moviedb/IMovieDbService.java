package com.bcefit.projet.service.moviedb;

import com.bcefit.projet.domain.wish.WishEpisode;

import java.util.List;

public interface IMovieDbService {

    List<WishEpisode> getWishEpisodeListByIdTv(Integer idTv);


    List<WishEpisode> getWishEpisodeListByIdSeason(Integer idTv, Integer numberSeason);

    void getMovieDetail(Integer idMovie);
}
