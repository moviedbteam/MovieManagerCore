package com.bcefit.projet.service.user;

import com.bcefit.projet.domain.user.GenreMovie;

public interface IGenreMovieService {

    Iterable<GenreMovie> findAll();

    GenreMovie findById(Long id);
}
