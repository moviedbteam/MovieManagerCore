package com.bcefit.projet.service.wish;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.wish.WishEpisode;

public interface IWishEpisodeService {

    Iterable<WishEpisode> findAllByUserAccountId(UserAccount userAccount);

    WishEpisode findById(Long id);


    void deleteWishEpisode(WishEpisode wishEpisode);

    WishEpisode createWishEpisode(WishEpisode wishEpisode);

    WishEpisode getIdWishEpisodeByIdSerieAndUserAccount(Long idEpisode, UserAccount userAccount);

    WishEpisode findByIdEpisode(Long idEpisode);
}
