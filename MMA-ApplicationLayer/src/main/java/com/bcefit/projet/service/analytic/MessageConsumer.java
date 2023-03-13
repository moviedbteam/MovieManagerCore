package com.bcefit.projet.service.analytic;


import com.bcefit.projet.domain.moviedb.Movie;
import com.bcefit.projet.domain.moviedb.Tv;
import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.service.mapper.MovieMessageMapper;
import com.bcefit.projet.service.mapper.TvMessageMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

@Autowired
MovieMessageMapper movieMessageMapper;

@Autowired
TvMessageMapper tvMessageMapper;

@Autowired
IAnalyticService iAnalyticService;


@JmsListener(destination = "Q_ADD_Watch_MOVIE")
    public void consumeAddWatchMovieMessage(String message){
    //WatchMovie watchMovie = watchMovieMapper.convertMessageToEntity(message);
    Movie movie = movieMessageMapper.convertMessageToMovie(message);
    UserAccount userAccount = tvMessageMapper.convertMessageToUserAccount(message);
    iAnalyticService.addWatchMovieAnalytic(movie , userAccount);
}


@JmsListener(destination = "Q_ADD_Watch_EPISODE")
public void consumeAddWatchEpisodeMessage(String message){
    Tv tv = tvMessageMapper.convertMessageToTv(message);
    UserAccount userAccount = tvMessageMapper.convertMessageToUserAccount(message);
    iAnalyticService.addWatchTvAnalytic(tv , userAccount);
}


@JmsListener(destination = "Q_ADD_Wish_MOVIE")
public void consumeAddWishMovieMessage(String message){
    //WatchMovie watchMovie = watchMovieMapper.convertMessageToEntity(message);
    Movie movie = movieMessageMapper.convertMessageToMovie(message);
    UserAccount userAccount = tvMessageMapper.convertMessageToUserAccount(message);
    iAnalyticService.addWishMovieAnalytic(movie , userAccount);
}



@JmsListener(destination = "Q_ADD_Wish_EPISODE")
public void consumeAddWishEpisodeMessage(String message){
    Tv tv = tvMessageMapper.convertMessageToTv(message);
    UserAccount userAccount = tvMessageMapper.convertMessageToUserAccount(message);
    iAnalyticService.addWishTvAnalytic(tv , userAccount);
}


}
