package com.bcefit.projet.service.watch;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.watch.WatchEpisode;

import java.util.List;

public interface IWatchSeasonService {
    List<WatchEpisode> createWatchEpisodeBySeasonId(Long idTv, Long idSeason, UserAccount userAccount);

    List<WatchEpisode> deleteWatchEpisodeBySeasonId(Long idTv, Long idSeason, UserAccount userAccount);
}
