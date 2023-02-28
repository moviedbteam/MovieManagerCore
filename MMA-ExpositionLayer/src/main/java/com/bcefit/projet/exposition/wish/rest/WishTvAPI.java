package com.bcefit.projet.exposition.wish.rest;


import com.bcefit.projet.exposition.wish.dto.WishEpisodeDto;
import com.bcefit.projet.exposition.wish.dto.WishTvDto;
import com.bcefit.projet.exposition.wish.mapper.WishEpisodeMapper;
import com.bcefit.projet.exposition.wish.mapper.WishTvMapper;
import com.bcefit.projet.service.wish.IWishTvService;
import info.movito.themoviedbapi.model.tv.TvSeries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wish")
public class WishTvAPI {

    @Autowired
    IWishTvService service;

    @Autowired
    WishTvMapper mapperTv;

    @Autowired
    WishEpisodeMapper mapperEpisode;

    Logger logger = LoggerFactory.getLogger(WishTvAPI.class);


    @PostMapping("/tv")
    public ResponseEntity<List<WishEpisodeDto>> createWishByIdTv(@RequestBody WishTvDto wishTvDto){

        logger.info("Nouvelle demande d'enregistrement de wish episode by idTv {}",wishTvDto.getIdTv());

        TvSeries tvSeries = mapperTv.convertDtoToEntity(wishTvDto);

        List<WishEpisodeDto> wishEpisodeDtoList = mapperEpisode.convertListEntityToDto(service.createWishEpisodeByTvId(tvSeries));

        return ResponseEntity.status(HttpStatus.CREATED).body(wishEpisodeDtoList);
    }
}
