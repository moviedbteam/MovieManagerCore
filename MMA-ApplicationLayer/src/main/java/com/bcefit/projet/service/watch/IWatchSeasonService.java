package com.bcefit.projet.service.watch;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.watch.WatchEpisode;

import java.util.List;

public interface IWatchSeasonService {
    List<WatchEpisode> createWatchEpisodeBySeasonId(Integer idTv, Integer idSeason, UserAccount userAccount);

    List<WatchEpisode> deleteWatchEpisodeBySeasonId(Integer idTv, Integer idSeason, UserAccount userAccount);
}
