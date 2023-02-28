package com.bcefit.projet.infrastructure;

import com.bcefit.projet.domain.watch.WatchEpisode;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IWatchEpisodeRepository extends CrudRepository<WatchEpisode, Long> {

    Optional<List<WatchEpisode>> findWatchEpisodesByUserAccount(Long Long);
}
