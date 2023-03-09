package com.bcefit.projet.service.wish;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.wish.WishEpisode;

import java.util.List;

public interface IWishSeasonService {

    List<WishEpisode> createWishEpisodeBySeasonId(Long idTv, Long idSeason, UserAccount userAccount);

    List<WishEpisode> deleteWishEpisodeBySeasonId(Long idTv, Long idSeason, UserAccount userAccount);
}
