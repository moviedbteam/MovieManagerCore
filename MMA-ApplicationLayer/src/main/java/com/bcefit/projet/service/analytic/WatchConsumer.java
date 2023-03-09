package com.bcefit.projet.service.analytic;


import com.bcefit.projet.domain.watch.WatchEpisode;
import com.bcefit.projet.domain.watch.WatchMovie;
import com.bcefit.projet.service.mapper.WatchEpisodeMsgMapper;

import com.bcefit.projet.service.mapper.WatchMovieMsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class WatchConsumer {

@Autowired
WatchMovieMsgMapper watchMovieMapper;

@Autowired
WatchEpisodeMsgMapper watchEpisodeMapper;

@Autowired
IAnalyticService iAnalyticService;


@JmsListener(destination = "Q_ADD_Watch_MOVIE")
    public void consumeAddWatchMovieMessage(String message){
    //WatchMovie watchMovie = watchMovieMapper.convertMessageToEntity(message);
    //iAnalyticService.addWatchMovieAnalytic(watchMovie);
}

@JmsListener(destination = "Q_DELETE_Watch_MOVIE")
public void consumeDelWatchMovieMessage(String message){
    //WatchMovie watchMovie = watchMovieMapper.convertMessageToEntity(message);
    //iAnalyticService.delWatchMovieAnalytic(watchMovie);
}

@JmsListener(destination = "Q_ADD_Watch_EPISODE")
public void consumeAddWatchEpisodeMessage(String message){
    //WatchEpisode watchEpisode = watchEpisodeMapper.convertMessageToEntity(message);
    //iAnalyticService.addWatchEpisodeAnalytic(watchEpisode);
}

@JmsListener(destination = "Q_DELETE_Watch_EPISODE")
public void consumeDelWatchEpisodeMessage(String message){
    //WatchEpisode watchEpisode = watchEpisodeMapper.convertMessageToEntity(message);
    //iAnalyticService.delWatchEpisodeAnalytic(watchEpisode);
}

}
