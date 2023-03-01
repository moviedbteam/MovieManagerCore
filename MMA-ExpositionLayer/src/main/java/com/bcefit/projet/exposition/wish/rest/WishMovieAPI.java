package com.bcefit.projet.exposition.wish.rest;


import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.wish.WishMovie;
import com.bcefit.projet.exposition.wish.dto.WishMovieDto;
import com.bcefit.projet.exposition.wish.mapper.WishMovieMapper;
import com.bcefit.projet.service.wish.IWishMovieService;
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
public class WishMovieAPI {

    @Autowired
    IWishMovieService service;

    @Autowired
    WishMovieMapper mapper;

    Logger logger = LoggerFactory.getLogger(WishMovieAPI.class);

    @GetMapping("/movie/{idWishMovie}")
    public WishMovieDto getWishMovieById(@PathVariable("idWishMovie") Long idWish){
        logger.info("Nouvelle demande pour le wish movie {}", idWish);
        WishMovie wishMovie = service.findById(idWish);
        logger.debug("DEBUG---ID Wish movie = {}", wishMovie.getIdWish());
        return mapper.convertEntityToDto(wishMovie);
    }

    @PostMapping("/movie")
    public ResponseEntity<WishMovieDto> create(@RequestBody WishMovieDto wishMovieDto){

        logger.info("Nouvelle demande d'enregistrement wish movie {}",wishMovieDto.getIdWish());

        WishMovie wishMovie = mapper.convertDtoToEntity(wishMovieDto);

        WishMovieDto dto = mapper.convertEntityToDto(service.createWishMovie(wishMovie));

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/movie/all")
    public List<WishMovieDto> getAllWishMoviess(){logger.info("nouvelle demande de liste de wish movie");
        Iterable<WishMovie> iterable=service.findAllByUserAccountId(new UserAccount());
        List<WishMovieDto> wishMovieDtoList = new ArrayList<>();

        iterable.forEach((pEntity)-> wishMovieDtoList.add(mapper.convertEntityToDto(pEntity)));

        return wishMovieDtoList;
    }

    @DeleteMapping( "/movie/{idWishMovie}")
    public ResponseEntity<String> deleteWishMovie(@PathVariable Long idWishMovie){

        logger.info("Nouvelle demande de suppression wish movie {}",idWishMovie);
        WishMovie wishMovie = new WishMovie();
        wishMovie.setIdWish(idWishMovie);
        service.deleteWishMovie(wishMovie);

        return new  ResponseEntity<>("Wish movie supprimé!",HttpStatus.OK);
    }

}
