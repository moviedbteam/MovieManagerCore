package com.bcefit.projet.exposition.wish.rest;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.exposition.wish.dto.WishEpisodeDto;
import com.bcefit.projet.exposition.wish.dto.WishTvSeasonDto;
import com.bcefit.projet.exposition.wish.mapper.WishEpisodeMapper;
import com.bcefit.projet.service.user.IUserAccountService;
import com.bcefit.projet.service.wish.IWishSeasonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wish")
public class WishSeasonAPI {

    @Autowired
    IUserAccountService iUserAccountService;

    @Autowired
    IWishSeasonService service;

    @Autowired
    WishEpisodeMapper mapperEpisode;

    Logger logger = LoggerFactory.getLogger(WishSeasonAPI.class);


    @PostMapping("/season")
    public ResponseEntity<List<WishEpisodeDto>> createWishByIdSeason(@RequestBody WishTvSeasonDto wishTvSeasonDto, @RequestAttribute("userEmail") String userEmail){

        Integer idTv = wishTvSeasonDto.getIdTv();
        Integer idSeason = wishTvSeasonDto.getIdSeason();

        logger.info("Nouvelle demande d'ajout de wish episode by numberSeason {}",idTv," pour la séries {}"+idSeason);
        UserAccount userAccount = iUserAccountService.logToUserAccount(userEmail);
        if(userAccount ==null){
            ResponseEntity.status(HttpStatus.UNAUTHORIZED);
        }

        List<WishEpisodeDto> wishEpisodeDtoList = mapperEpisode.convertListEntityToDto(service.createWishEpisodeBySeasonId(idTv,idSeason, userAccount));

        return ResponseEntity.status(HttpStatus.CREATED).body(wishEpisodeDtoList);
    }

    @DeleteMapping("/season")
    public ResponseEntity<List<WishEpisodeDto>> deleteWishByIdSeason(@RequestBody WishTvSeasonDto wishTvSeasonDto, @RequestAttribute("userEmail") String userEmail){

        Integer idTv = wishTvSeasonDto.getIdTv();
        Integer idSeason = wishTvSeasonDto.getIdSeason();

        logger.info("Nouvelle demande de suppression de wish episode by numberSeason {}",idTv," pour la séries {}"+idSeason);
        UserAccount userAccount = iUserAccountService.logToUserAccount(userEmail);
        if(userAccount ==null){
            ResponseEntity.status(HttpStatus.UNAUTHORIZED);
        }

        List<WishEpisodeDto> wishEpisodeDtoList = mapperEpisode.convertListEntityToDto(service.deleteWishEpisodeBySeasonId(idTv,idSeason, userAccount));

        return ResponseEntity.status(HttpStatus.CREATED).body(wishEpisodeDtoList);
    }
}