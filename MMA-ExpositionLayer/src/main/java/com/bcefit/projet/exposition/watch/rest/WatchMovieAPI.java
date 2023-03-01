package com.bcefit.projet.exposition.watch.rest;


import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.watch.WatchMovie;
import com.bcefit.projet.exposition.watch.dto.WatchMovieDto;
import com.bcefit.projet.exposition.watch.mapper.WatchMovieMapper;
import com.bcefit.projet.service.common.ILogginService;
import com.bcefit.projet.service.user.IUserAccountService;
import com.bcefit.projet.service.user.UserAccountServiceImpl;
import com.bcefit.projet.service.watch.IWatchMovieService;
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
public class WatchMovieAPI {

    @Autowired
    ILogginService logginService;

    @Autowired
    IWatchMovieService service;

    @Autowired
    WatchMovieMapper mapper;

    @Autowired
    IUserAccountService iUserAccountService;

    Logger logger = LoggerFactory.getLogger(WatchMovieAPI.class);

    @GetMapping("/movie/{idWatchMovie}")
    public WatchMovieDto getWatchMovieById(@PathVariable("idWatchMovie") Long idWatch){
        logger.info("Nouvelle demande pour le watch movie {}", idWatch);
        WatchMovie watchMovie = service.findById(idWatch);
        logger.debug("DEBUG---ID Watch movie = {}", watchMovie.getIdWatch());
        return mapper.convertEntityToDto(watchMovie);
    }

    @PostMapping("/movie")
    public ResponseEntity<WatchMovieDto> create(@RequestBody WatchMovieDto watchMovieDto,@RequestAttribute("userLoggin") String userLoggin){

        logger.info("Nouvelle demande de création de watch movie le UserAccount (loggin) {}", userLoggin);
        Long idUser = logginService.getIdUserByUserLoggin(userLoggin);
        UserAccount userAccount = iUserAccountService.findById(idUser);

        WatchMovie watchMovie = mapper.convertDtoToEntity(watchMovieDto);
        watchMovie.setUserAccount(userAccount);

        WatchMovieDto dto = mapper.convertEntityToDto(service.createWatchMovie(watchMovie));

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/movie/all")
    public ResponseEntity<List<WatchMovieDto>> getAllWatchMoviess(@RequestAttribute("userLoggin") String userLoggin){
        logger.info("Nouvelle demande pour le UserAccount (loggin) {}", userLoggin);
        Long idUser = logginService.getIdUserByUserLoggin(userLoggin);


        logger.info("nouvelle demande de liste de watch movie");
        Iterable<WatchMovie> iterable=service.findAllByUserAccountId(idUser);
        List<WatchMovieDto> watchMovieDtoList = new ArrayList<>();

        iterable.forEach((pEntity)-> watchMovieDtoList.add(mapper.convertEntityToDto(pEntity)));

        return ResponseEntity.status(HttpStatus.OK).body(watchMovieDtoList);
    }

    @DeleteMapping("/movie/{idWatchMovie}")
    public ResponseEntity<String> deleteWatchMovie(@PathVariable Long idWatchMovie,@RequestAttribute("userLoggin") String userLoggin){
        logger.info("Nouvelle demande de création de watch movie le UserAccount (loggin) {}", userLoggin);
        Long idUser = logginService.getIdUserByUserLoggin(userLoggin);
        UserAccount userAccount = iUserAccountService.findById(idUser);

        logger.info("Nouvelle demande de suppression watch movie {}",idWatchMovie);
        WatchMovie watchMovie = new WatchMovie();
        watchMovie.setIdWatch(idWatchMovie);
        watchMovie.setUserAccount(userAccount);

        service.deleteWatchMovie(watchMovie);

        return new  ResponseEntity<>("Watch movie supprimé!",HttpStatus.OK);
    }

}
