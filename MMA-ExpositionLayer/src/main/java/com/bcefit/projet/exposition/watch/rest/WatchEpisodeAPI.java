package com.bcefit.projet.exposition.watch.rest;


import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.watch.WatchEpisode;
import com.bcefit.projet.exposition.watch.dto.WatchEpisodeDto;
import com.bcefit.projet.exposition.watch.mapper.WatchEpisodeMapper;
import com.bcefit.projet.service.watch.IWatchEpisodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/watch")
public class WatchEpisodeAPI {

    @Autowired
    IWatchEpisodeService service;

    @Autowired
    WatchEpisodeMapper mapper;

    Logger logger = LoggerFactory.getLogger(WatchEpisodeAPI.class);


    @GetMapping("/episode/{idWatchEpisode}")
    public WatchEpisodeDto getWatchEpisodeById(@PathVariable("idWatchEpisode") Long idWatch){
        logger.info("Nouvelle demande pour le watch Episode {}", idWatch);
        WatchEpisode watchEpisode = service.findById(idWatch);
        logger.debug("DEBUG---ID Watch Episode = {}", watchEpisode.getIdWatch());
        return mapper.convertEntityToDto(watchEpisode);
    }

    @PostMapping("/episode")
    public ResponseEntity<WatchEpisodeDto> create(@RequestBody WatchEpisodeDto watchEpisodeDto){

        logger.info("Nouvelle demande d'enregistrement watch Episode {}",watchEpisodeDto.getIdWatch());

        WatchEpisode watchEpisode = mapper.convertDtoToEntity(watchEpisodeDto);

        WatchEpisodeDto dto = mapper.convertEntityToDto(service.createWatchEpisode(watchEpisode));

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/episode/all")
    public List<WatchEpisodeDto> getAllWatchEpisodess(){logger.info("nouvelle demande de liste de watch Episode");
        Iterable<WatchEpisode> iterable=service.findAllByUserAccountId(new UserAccount());
        List<WatchEpisodeDto> watchEpisodeDtoList = new ArrayList<>();

        iterable.forEach((pEntity)-> watchEpisodeDtoList.add(mapper.convertEntityToDto(pEntity)));

        return watchEpisodeDtoList;
    }

    @DeleteMapping("/episode/{idWatchEpisode}")
    public ResponseEntity<String> deleteWatchEpisode(@PathVariable Long idWatchEpisode){

        logger.info("Nouvelle demande de suppression watch Episode {}",idWatchEpisode);
        WatchEpisode watchEpisode = new WatchEpisode();
        watchEpisode.setIdWatch(idWatchEpisode);
        service.deleteWatchEpisode(watchEpisode);

        return new  ResponseEntity<>("Watch Episode supprimé!",HttpStatus.OK);
    }

}
