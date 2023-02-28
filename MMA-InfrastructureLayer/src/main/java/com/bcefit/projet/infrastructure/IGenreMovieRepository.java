package com.bcefit.projet.infrastructure;

import com.bcefit.projet.domain.user.GenreMovie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface IGenreMovieRepository extends CrudRepository<GenreMovie, Long> {

    //List<GenreMovie> findGenreMoviesByUserAccountSet(Long idUser);
}
