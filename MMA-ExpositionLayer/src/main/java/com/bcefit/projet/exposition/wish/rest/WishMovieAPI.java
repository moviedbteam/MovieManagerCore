package com.bcefit.projet.exposition.wish.rest;


import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.wish.WishMovie;
import com.bcefit.projet.exposition.wish.dto.WishMovieDto;
import com.bcefit.projet.exposition.wish.mapper.WishMovieMapper;
import com.bcefit.projet.service.user.IUserAccountService;
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
    IUserAccountService iUserAccountService;

    @Autowired
    IWishMovieService service;

    @Autowired
    WishMovieMapper mapper;

    Logger logger = LoggerFactory.getLogger(WishMovieAPI.class);

    @GetMapping("/movie/{idWishMovie}")
    public WishMovieDto getWishMovieById(@PathVariable("idWishMovie") Long idWish,@RequestAttribute("userEmail") String userEmail){
        logger.info("Nouvelle demande pour le wish movie {}", idWish);
        UserAccount userAccount = iUserAccountService.logToUserAccount(userEmail);
        if(userAccount ==null){
            ResponseEntity.status(HttpStatus.UNAUTHORIZED);
        }

        WishMovie wishMovie = service.findById(idWish);
        logger.debug("DEBUG---ID Wish movie = {}", wishMovie.getIdWish());
        return mapper.convertEntityToDto(wishMovie);
    }

    @PostMapping("/movie")
    public ResponseEntity<WishMovieDto> create(@RequestBody WishMovieDto wishMovieDto,@RequestAttribute("userEmail") String userEmail){

        logger.info("Nouvelle demande de création de wish movie avec le UserAccount (Email) {}", userEmail);
        UserAccount userAccount = iUserAccountService.logToUserAccount(userEmail);
        if(userAccount ==null){
            ResponseEntity.status(HttpStatus.UNAUTHORIZED);
        }

        WishMovie wishMovie = mapper.convertDtoToEntity(wishMovieDto);
        wishMovie.setUserAccount(userAccount);

        WishMovieDto dto = mapper.convertEntityToDto(service.createWishMovie(wishMovie));

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/movie/all")
    public ResponseEntity<List<WishMovieDto>> getAllWishMovies(@RequestAttribute("userEmail") String userEmail){
        logger.info("Nouvelle demande pour le UserAccount (Email) {}", userEmail);
        UserAccount userAccount = iUserAccountService.logToUserAccount(userEmail);
        if(userAccount ==null){
            ResponseEntity.status(HttpStatus.UNAUTHORIZED);
        }

        logger.info("nouvelle demande de liste de wish movie");
        Iterable<WishMovie> iterable=service.findAllByUserAccountId(userAccount);
        List<WishMovieDto> wishMovieDtoList = new ArrayList<>();

        iterable.forEach((pEntity)-> wishMovieDtoList.add(mapper.convertEntityToDto(pEntity)));

        return ResponseEntity.status(HttpStatus.OK).body(wishMovieDtoList);
    }

    @DeleteMapping( "/movie/{idWishMovie}")
    public ResponseEntity<String> deleteWishMovie(@PathVariable Long idWishMovie,@RequestAttribute("userEmail") String userEmail){
        logger.info("Nouvelle demande de création de watch movie le UserAccount (Email) {}", userEmail);
        UserAccount userAccount = iUserAccountService.logToUserAccount(userEmail);
        if(userAccount ==null){
            ResponseEntity.status(HttpStatus.UNAUTHORIZED);
        }

        logger.info("Nouvelle demande de suppression wish movie {}",idWishMovie);
        WishMovie wishMovie = new WishMovie();
        wishMovie.setIdWish(idWishMovie);
        service.deleteWishMovie(wishMovie);

        return new  ResponseEntity<>("Wish movie supprimé!",HttpStatus.OK);
    }

}
