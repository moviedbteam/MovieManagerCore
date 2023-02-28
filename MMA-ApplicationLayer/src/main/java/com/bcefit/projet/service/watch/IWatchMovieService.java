package com.bcefit.projet.service.watch;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.watch.WatchMovie;

public interface IWatchMovieService {

    Iterable<WatchMovie> findAllByUserAccountId(Long userId);

    WatchMovie findById(Long id);

    WatchMovie createWatchMovie(WatchMovie watchMovie);

    void deleteWatchMovie(WatchMovie watchMovie);
}
