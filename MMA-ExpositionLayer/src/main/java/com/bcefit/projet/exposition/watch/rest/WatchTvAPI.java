package com.bcefit.projet.exposition.watch.rest;


import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.exposition.watch.dto.WatchEpisodeDto;
import com.bcefit.projet.exposition.watch.dto.WatchTvSeasonDto;
import com.bcefit.projet.exposition.watch.mapper.WatchEpisodeMapper;
import com.bcefit.projet.service.user.IUserAccountService;
import com.bcefit.projet.service.watch.IWatchTvService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/watch")
public class WatchTvAPI {

    @Autowired
    IUserAccountService iUserAccountService;

    @Autowired
    IWatchTvService service;

    @Autowired
    WatchEpisodeMapper mapperEpisode;

    Logger logger = LoggerFactory.getLogger(WatchTvAPI.class);


    @PostMapping("/tv")
    public ResponseEntity<List<WatchEpisodeDto>> createWatchByIdTv(@RequestBody WatchTvSeasonDto watchTvSeasonDto, @RequestAttribute("userEmail") String userEmail){

        Integer idTv = watchTvSeasonDto.getIdTv();
        logger.info("Nouvelle demande d'ajout de watch episode by idTv {}",idTv);
        UserAccount userAccount = iUserAccountService.logToUserAccount(userEmail);
        if(userAccount ==null){
            ResponseEntity.status(HttpStatus.UNAUTHORIZED);
        }

        List<WatchEpisodeDto> watchEpisodeDtoList = mapperEpisode.convertListEntityToDto(service.createWatchEpisodeByTvId(idTv, userAccount));

        return ResponseEntity.status(HttpStatus.CREATED).body(watchEpisodeDtoList);
    }

    @DeleteMapping("/tv")
    public ResponseEntity<List<WatchEpisodeDto>> deleteWatchByIdTv(@RequestBody WatchTvSeasonDto watchTvSeasonDto,@RequestAttribute("userEmail") String userEmail){

        Integer idTv = watchTvSeasonDto.getIdTv();

        logger.info("Nouvelle demande de suppression de watch episode by idTv {}",idTv);
        UserAccount userAccount = iUserAccountService.logToUserAccount(userEmail);
        if(userAccount ==null){
            ResponseEntity.status(HttpStatus.UNAUTHORIZED);
        }

        List<WatchEpisodeDto> watchEpisodeDtoList = mapperEpisode.convertListEntityToDto(service.deleteWatchEpisodeByTvId(idTv, userAccount));

        return ResponseEntity.status(HttpStatus.CREATED).body(watchEpisodeDtoList);
    }
}
