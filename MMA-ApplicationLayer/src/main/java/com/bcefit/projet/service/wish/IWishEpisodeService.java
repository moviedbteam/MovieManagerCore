package com.bcefit.projet.service.wish;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.wish.WishEpisode;

import java.util.List;

public interface IWishEpisodeService {

    Iterable<WishEpisode> findAllByUserAccountId(UserAccount userAccount);

    WishEpisode findById(Long id);


    void deleteWishEpisode(WishEpisode wishEpisode);

    WishEpisode createWishEpisode(WishEpisode wishEpisode);
}
