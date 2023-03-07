package com.bcefit.projet.service.watch;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.watch.WatchEpisode;
import com.bcefit.projet.service.moviedb.IMovieDbService;
import com.bcefit.projet.service.watch.IWatchEpisodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WatchSeasonServiceImpl implements IWatchSeasonService {


    @Autowired
    IWatchEpisodeService service;

    @Autowired
    IMovieDbService iMovieDbService;

    Logger logger = LoggerFactory.getLogger(IWatchSeasonService.class);

    @Override
    public List<WatchEpisode> createWatchEpisodeBySeasonId(Integer idTv, Integer idSeason, UserAccount userAccount) {


        //création d'une liste pour stocker tous les épisodes d'une série (intérrogation de The Movie DB)
        List<WatchEpisode> watchEpisodeListForTV = iMovieDbService.getWatchEpisodeListByIdSeason(idTv,idSeason);
        List<WatchEpisode> watchEpisodeCreatedList = new ArrayList<>();

        for (WatchEpisode watchEpisode : watchEpisodeListForTV) {
            watchEpisode.setUserAccount(userAccount);
            WatchEpisode watchEpisodeIsExist = service.getIdWatchEpisodeByIdSerieAndUserAccount(watchEpisode.getIdEpisode(), userAccount);
            if (watchEpisodeIsExist == null) {
                service.createWatchEpisode(watchEpisode);
                watchEpisodeCreatedList.add(watchEpisode);
            }
        }
        return watchEpisodeCreatedList;
    }

    @Override
    public List<WatchEpisode> deleteWatchEpisodeBySeasonId(Integer idTv, Integer idSeason,  UserAccount userAccount) {

        //création d'une liste pour stocker tous les épisodes d'une série (intérrogation de The Movie DB)
        List<WatchEpisode> watchEpisodeListForTV = iMovieDbService.getWatchEpisodeListByIdSeason(idTv,idSeason);
        List<WatchEpisode> watchEpisodeDeletedList = new ArrayList<>();

        for (WatchEpisode watchEpisode : watchEpisodeListForTV) {
            WatchEpisode watchEpisodeToDelete = service.getIdWatchEpisodeByIdSerieAndUserAccount(watchEpisode.getIdEpisode(),userAccount);
            if (watchEpisodeToDelete != null) {
                service.deleteWatchEpisode(watchEpisodeToDelete);
                watchEpisodeDeletedList.add(watchEpisode);
            }
        }
        return watchEpisodeDeletedList;
    }
}
