package com.bcefit.projet.service.user;


import com.bcefit.projet.domain.user.GenreTv;

public interface IGenreTvService {

    Iterable<GenreTv> findAll();

    GenreTv findById(Long id);
}
