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
public class WatchTvServiceImpl implements IWatchTvService {
    @Autowired
    IWatchEpisodeService service;

    @Autowired
    IMovieDbService iMovieDbService;

    Logger logger = LoggerFactory.getLogger(IWatchTvService.class);

    public List<WatchEpisode> createWatchEpisodeByTvId(Integer idTv, UserAccount userAccount) {

        //création d'une liste pour stocker tous les épisodes d'une série (intérrogation de The Movie DB)
        List<WatchEpisode> watchEpisodeListForTV = iMovieDbService.getWatchEpisodeListByIdTv(idTv);
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
    public List<WatchEpisode> deleteWatchEpisodeByTvId(Integer idTv, UserAccount userAccount) {

        //création d'une liste pour stocker tous les épisodes d'une série (intérrogation de The Movie DB)
        List<WatchEpisode> watchEpisodeListForTV = iMovieDbService.getWatchEpisodeListByIdTv(idTv);
        List<WatchEpisode> watchEpisodeDeletedList = new ArrayList<>();

        for (WatchEpisode watchEpisode : watchEpisodeListForTV) {
            WatchEpisode watchEpisodeToDelete = service.getIdWatchEpisodeByIdSerieAndUserAccount(watchEpisode.getIdEpisode(), userAccount);
            if (watchEpisodeToDelete != null) {
                service.deleteWatchEpisode(watchEpisodeToDelete);
                watchEpisodeDeletedList.add(watchEpisode);
            }
        }
        return watchEpisodeDeletedList;
    }
}

