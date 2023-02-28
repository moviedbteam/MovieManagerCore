package com.bcefit.projet.exposition.wish.mapper;

import com.bcefit.projet.exposition.wish.dto.WishTvDto;
import info.movito.themoviedbapi.model.tv.TvSeries;
import org.springframework.stereotype.Component;

@Component
public class WishTvMapper {

    public TvSeries convertDtoToEntity(WishTvDto dto){
        TvSeries tvSeries = new TvSeries();
        tvSeries.setId(dto.getIdTv().intValue());
        return tvSeries;
    }
}
