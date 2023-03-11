package com.bcefit.projet.service.moviedb;

import com.bcefit.projet.domain.moviedb.GenreTv;
import com.bcefit.projet.domain.moviedb.Tv;

import java.util.List;

public interface ITvService {

    Tv getDetailByIdTv(Long idTv);

    Tv getAllDetailByIdTv(Long idTv);


}
