package com.bcefit.projet.infrastructure;

import com.bcefit.projet.domain.moviedb.GenreTv;
import com.bcefit.projet.domain.moviedb.Season;
import com.bcefit.projet.domain.moviedb.StreamingSubscription;

import java.util.List;

/**
 * A Projection for the {@link com.bcefit.projet.domain.moviedb.Tv} entity
 */
public interface TvFullDetails {
    Long getIdTv();

    List<Integer> getEpisodeRuntime();

    String getFirstAirDate();

    String getLastAirDate();

    String getHomepage();

    String getOriginalName();

    List<String> getOriginCountry();

    String getOverview();

    float getPopularity();

    String getBackdropPath();

    String getPosterPath();

    int getNumberOfEpisodes();

    int getNumberOfSeasons();

    float getVoteAverage();

    int getVoteCount();

    String getStatus();

    List<GenreTv> getGenreTvList();

    List<StreamingSubscription> getStreamingSubscriptionList();

    List<Season> getSeasons();
}