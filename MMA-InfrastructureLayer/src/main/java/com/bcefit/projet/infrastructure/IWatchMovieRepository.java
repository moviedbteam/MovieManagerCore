package com.bcefit.projet.infrastructure;

import com.bcefit.projet.domain.watch.WatchMovie;
import com.bcefit.projet.domain.wish.WishMovie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IWatchMovieRepository extends CrudRepository<WatchMovie, Long> {

    Optional<List<WatchMovie>> findWatchMoviesByUserAccount(Long Long);
}
