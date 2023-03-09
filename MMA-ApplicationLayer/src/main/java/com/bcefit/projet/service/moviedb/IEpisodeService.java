package com.bcefit.projet.service.moviedb;

import com.bcefit.projet.domain.moviedb.Episode;

import java.util.List;

public interface IEpisodeService {

    Episode getEpisodeDetail(Long idTv, Long idEpisode);

    List<Episode> getAllEpisodeByIdTv (Long idTv);

    List<Episode> getAllEpisodeByIdTvAndIdSeason(Long idTv,Long idSeason);
    
}
