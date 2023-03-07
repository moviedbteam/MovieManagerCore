package com.bcefit.projet.service.watch;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.watch.WatchEpisode;

import java.util.List;

public interface IWatchTvService {

    List<WatchEpisode> createWatchEpisodeByTvId(Integer idTv, UserAccount userAccount);

    List<WatchEpisode> deleteWatchEpisodeByTvId(Integer idSeason, UserAccount userAccount);


}
