package com.bcefit.projet.exposition.recommendation.rest;


import com.bcefit.projet.domain.moviedb.Movie;
import com.bcefit.projet.domain.moviedb.Tv;
import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.exposition.recommendation.dto.MovieRecommendationDto;
import com.bcefit.projet.exposition.recommendation.dto.TvRecommendationDto;
import com.bcefit.projet.exposition.recommendation.mapper.MovieRecommendationMapper;
import com.bcefit.projet.exposition.recommendation.mapper.TvRecommendationMapper;
import com.bcefit.projet.service.analytic.IMovieRecommendationService;
import com.bcefit.projet.service.analytic.ITvRecommendationService;
import com.bcefit.projet.service.user.IUserAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/recommendation")
@Api(value = "Recommendation API", description = "API de consultation des recommendations")
public class Recommendation {

    @Autowired
    IMovieRecommendationService iMovieRecommendationService;
    @Autowired
    ITvRecommendationService iTvRecommendationService;
    @Autowired
    IUserAccountService iUserAccountService;
    @Autowired
    MovieRecommendationMapper movieRecommendationMapper;
    @Autowired
    TvRecommendationMapper tvRecommendationMapper;
    Logger logger = LoggerFactory.getLogger(Recommendation.class);

    @ApiOperation(value = "Liste des films recommandés", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/movie")
    public ResponseEntity<List<MovieRecommendationDto>> getMovieRecommendationList(@RequestAttribute("userEmail") String userEmail) {

        logger.info("Nouvelle demande de recommendation Movie le UserAccount (Email) {}", userEmail);
        // Contrôle d'identification de l'utilisateur avec l'email issu du Token
        // Chargement du UserAccount
        UserAccount userAccount = iUserAccountService.logToUserAccount(userEmail);
        if(userAccount ==null){
            ResponseEntity.status(HttpStatus.UNAUTHORIZED);
        }
        List<Movie> movieList = iMovieRecommendationService.getMovieRecommendationByUserAccount(userAccount);
        if (movieList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }else {
            List<MovieRecommendationDto> movieRecommendationDtoList = movieRecommendationMapper.convertListEntityToDto(movieList);
            return ResponseEntity.status(HttpStatus.OK).body(movieRecommendationDtoList);
        }
    }

    @GetMapping("/tv")
    public ResponseEntity<List<TvRecommendationDto>> getTvRecommendationList(@RequestAttribute("userEmail") String userEmail) {

        logger.info("Nouvelle demande de recommendation Tv le UserAccount (Email) {}", userEmail);
        // Contrôle d'identification de l'utilisateur avec l'email issu du Token
        // Chargement du UserAccount
        UserAccount userAccount = iUserAccountService.logToUserAccount(userEmail);
        if(userAccount ==null){
            ResponseEntity.status(HttpStatus.UNAUTHORIZED);
        }
        List<Tv> tvList = iTvRecommendationService.getTvRecommendationByUserAccount(userAccount);
        if (tvList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }else {
            List<TvRecommendationDto> tvRecommendationDtoList = tvRecommendationMapper.convertListEntityToDto(tvList);
            return ResponseEntity.status(HttpStatus.OK).body(tvRecommendationDtoList);
        }
    }

}
