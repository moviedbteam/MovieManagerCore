package com.bcefit.projet.service.mapper;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.watch.WatchMovie;
import com.bcefit.projet.service.user.UserAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WatchMovieMessageMapper {

    @Autowired
    UserAccountServiceImpl userAccountService;

    public String convertEntityToMessage(WatchMovie entity){
        String message = new String();
        message += entity.getIdWatch().toString()+"/";
        message += entity.getIdMovie().toString()+"/";
        message += entity.getIdCollection().toString()+"/";
        message += entity.getUserAccount().getIdUser()+"/";
        message += entity.getViewingPlace()+"/";
        message += entity.getViewingMood()+"/";
        message += entity.getViewingRate();

        return message;
    }

    public WatchMovie convertMessageToEntity(String message){
    WatchMovie watchMovie = new WatchMovie();
    String[] tabString = message.split("/");
    watchMovie.setIdWatch(Long.valueOf(tabString[0]));
    watchMovie.setIdMovie(Long.valueOf(tabString[1]));
    watchMovie.setIdCollection(Long.valueOf(tabString[2]));
    UserAccount userAccount = userAccountService.findById(Long.valueOf(tabString[3]));
    watchMovie.setUserAccount(userAccount);
    watchMovie.setViewingPlace(tabString[4]);
    watchMovie.setViewingMood(Integer.valueOf(tabString[5]));
    watchMovie.setViewingRate(Integer.valueOf(tabString[6]));

    return watchMovie;
    }
}
