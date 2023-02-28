package com.bcefit.projet.service.wish;

import com.bcefit.projet.domain.wish.WishEpisode;
import info.movito.themoviedbapi.model.tv.TvSeries;

import java.util.List;

public interface IWishTvService {

    List<WishEpisode> createWishEpisodeByTvId(TvSeries tvSeries);
}
