package com.bcefit.projet.service.wish;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.wish.WishEpisode;
import info.movito.themoviedbapi.model.tv.TvSeries;

import java.util.List;
import java.util.Set;

public interface IWishTvService {



    List<WishEpisode> createWishEpisodeByTvId(Long idTv, UserAccount userAccount);

    List<WishEpisode> deleteWishEpisodeByTvId(Long idSeason, UserAccount userAccount);

    Set<Long> getIdTvByUserAccount(UserAccount userAccount);
}
