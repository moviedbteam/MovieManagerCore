package com.bcefit.projet.infrastructure;

import com.bcefit.projet.domain.watch.WatchMovie;
import org.springframework.data.repository.CrudRepository;


public interface IWatchMovieRepository extends CrudRepository<WatchMovie, Long> {

}
