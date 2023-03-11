package com.bcefit.projet.service.watch;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.watch.WatchEpisode;

public interface IWatchEpisodeService {

    Iterable<WatchEpisode> findAllByUserAccountId(UserAccount userAccount);

    WatchEpisode findById(Long id);


    void deleteWatchEpisode(WatchEpisode watchEpisode);

    WatchEpisode createWatchEpisode(WatchEpisode watchEpisode);

    WatchEpisode getIdWatchEpisodeByIdSerieAndUserAccount(Long idEpisode, UserAccount userAccount);

    WatchEpisode findByIdEpisode(Long idEpisode);
}
