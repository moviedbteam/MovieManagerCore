package com.bcefit.projet.infrastructure;

import com.bcefit.projet.domain.wish.WishEpisode;
import com.bcefit.projet.domain.wish.WishMovie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IWishEpisodeRepository extends CrudRepository<WishEpisode, Long> {


}
