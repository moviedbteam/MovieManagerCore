package com.bcefit.projet.infrastructure;

import com.bcefit.projet.domain.moviedb.Movie;
import com.bcefit.projet.domain.moviedb.Tv;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ITvRepository extends CrudRepository<Tv, Long> {

    @Query("select m from Tv m where m.idTv = ?1")
    Tv findByIdTv(Long idMovie);
}
