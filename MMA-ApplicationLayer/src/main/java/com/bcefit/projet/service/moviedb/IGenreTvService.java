package com.bcefit.projet.service.moviedb;


import com.bcefit.projet.domain.moviedb.GenreTv;

public interface IGenreTvService {

    Iterable<GenreTv> findAll();

    GenreTv findById(Long id);
}
