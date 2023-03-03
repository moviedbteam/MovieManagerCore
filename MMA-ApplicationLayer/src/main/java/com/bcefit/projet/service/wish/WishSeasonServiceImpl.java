package com.bcefit.projet.service.wish;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.wish.WishEpisode;
import com.bcefit.projet.service.moviedb.IMovieDbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishSeasonServiceImpl implements IWishSeasonService{


    @Autowired
    IWishEpisodeService service;

    @Autowired
    IMovieDbService iMovieDbService;

    Logger logger = LoggerFactory.getLogger(IWishSeasonService.class);

    @Override
    public List<WishEpisode> createWishEpisodeBySeasonId(Integer idTv, Integer idSeason, UserAccount userAccount) {


        //création d'une liste pour stocker tous les épisodes d'une série (intérrogation de The Movie DB)
        List<WishEpisode> wishEpisodeListForTV = iMovieDbService.getWishEpisodeListByIdSeason(idTv,idSeason);
        List<WishEpisode> wishEpisodeCreatedList = new ArrayList<>();

        for (WishEpisode wishEpisode : wishEpisodeListForTV) {
            wishEpisode.setUserAccount(userAccount);
            WishEpisode wishEpisodeIsExist = service.getIdWishEpisodeByIdSerieAndUserAccount(wishEpisode.getIdEpisode(), userAccount);
            if (wishEpisodeIsExist == null) {
                service.createWishEpisode(wishEpisode);
                wishEpisodeCreatedList.add(wishEpisode);
            }
        }
        return wishEpisodeCreatedList;
    }

    @Override
    public List<WishEpisode> deleteWishEpisodeBySeasonId(Integer idTv, Integer idSeason,  UserAccount userAccount) {

        //création d'une liste pour stocker tous les épisodes d'une série (intérrogation de The Movie DB)
        List<WishEpisode> wishEpisodeListForTV = iMovieDbService.getWishEpisodeListByIdSeason(idTv,idSeason);
        List<WishEpisode> wishEpisodeDeletedList = new ArrayList<>();

        for (WishEpisode wishEpisode : wishEpisodeListForTV) {
            WishEpisode wishEpisodeToDelete = service.getIdWishEpisodeByIdSerieAndUserAccount(wishEpisode.getIdEpisode(),userAccount);
            if (wishEpisodeToDelete != null) {
                service.deleteWishEpisode(wishEpisodeToDelete);
                wishEpisodeDeletedList.add(wishEpisode);
            }
        }
        return wishEpisodeDeletedList;
    }
}
