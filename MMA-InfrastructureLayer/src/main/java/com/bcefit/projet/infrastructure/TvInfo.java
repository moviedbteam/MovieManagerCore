package com.bcefit.projet.infrastructure;

import com.bcefit.projet.domain.moviedb.GenreTv;

import java.util.List;

/**
 * A Projection for the {@link com.bcefit.projet.domain.moviedb.Tv} entity
 */
public interface TvInfo {
    List<GenreTv> getGenreTvList();
}