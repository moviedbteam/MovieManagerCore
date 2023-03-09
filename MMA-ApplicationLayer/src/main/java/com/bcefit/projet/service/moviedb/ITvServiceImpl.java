package com.bcefit.projet.service.moviedb;


import com.bcefit.projet.domain.moviedb.Tv;
import com.bcefit.projet.infrastructure.ITvRepository;
import com.bcefit.projet.service.moviedb.api.ITmdbApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ITvServiceImpl implements ITvService {

    @Autowired
    ITvRepository iTvRepository;

    @Autowired
    ITmdbApiService iTmdbApiService;


    @Override
    public Tv getTvDetailByIdEpisode(Long idTv) {
        Tv tv = new Tv();
        tv = iTvRepository.findByIdTv(idTv);
        if (tv == null) {
            tv = iTmdbApiService.synchronizeTvDetailFromApiFromApi(idTv.intValue());
        }
        return tv;
    }
}
