package com.bcefit.projet.exposition.wish.rest;


import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.wish.WishEpisode;
import com.bcefit.projet.exposition.wish.dto.WishEpisodeDto;
import com.bcefit.projet.exposition.wish.mapper.WishEpisodeMapper;
import com.bcefit.projet.service.wish.IWishEpisodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/wish")
public class WishEpisodeAPI {

    @Autowired
    IWishEpisodeService service;

    @Autowired
    WishEpisodeMapper mapper;

    Logger logger = LoggerFactory.getLogger(WishEpisodeAPI.class);


    @GetMapping("/episode/{idWishEpisode}")
    public WishEpisodeDto getWishEpisodeById(@PathVariable("idWishEpisode") Long idWish){
        logger.info("Nouvelle demande pour le wish Episode {}", idWish);
        WishEpisode wishEpisode = service.findById(idWish);
        logger.debug("DEBUG---ID Wish Episode = {}", wishEpisode.getIdWish());
        return mapper.convertEntityToDto(wishEpisode);
    }

    @PostMapping("/episode")
    public ResponseEntity<WishEpisodeDto> create(@RequestBody WishEpisodeDto wishEpisodeDto){

        logger.info("Nouvelle demande d'enregistrement wish Episode {}",wishEpisodeDto.getIdWish());

        WishEpisode wishEpisode = mapper.convertDtoToEntity(wishEpisodeDto);

        WishEpisodeDto dto = mapper.convertEntityToDto(service.createWishEpisode(wishEpisode));

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/episode/all")
    public List<WishEpisodeDto> getAllWishEpisodess(){logger.info("nouvelle demande de liste de wish Episode");
        Iterable<WishEpisode> iterable=service.findAllByUserAccountId(new UserAccount());
        List<WishEpisodeDto> wishEpisodeDtoList = new ArrayList<>();

        iterable.forEach((pEntity)-> wishEpisodeDtoList.add(mapper.convertEntityToDto(pEntity)));

        return wishEpisodeDtoList;
    }

    @DeleteMapping("/episode/{idWishEpisode}")
    public ResponseEntity<String> deleteWishEpisode(@PathVariable Long idWishEpisode){

        logger.info("Nouvelle demande de suppression wish Episode {}",idWishEpisode);
        WishEpisode wishEpisode = new WishEpisode();
        wishEpisode.setIdWish(idWishEpisode);
        service.deleteWishEpisode(wishEpisode);

        return new  ResponseEntity<>("Wish Episode supprimé!",HttpStatus.OK);
    }

}
