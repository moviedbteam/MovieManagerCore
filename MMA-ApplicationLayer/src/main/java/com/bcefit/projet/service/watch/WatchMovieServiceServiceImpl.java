package com.bcefit.projet.service.watch;


import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.watch.WatchMovie;
import com.bcefit.projet.domain.wish.WishMovie;
import com.bcefit.projet.infrastructure.IWatchMovieRepository;
import com.bcefit.projet.infrastructure.IWatchMoviesByUserAccountRepository;
import com.bcefit.projet.infrastructure.IWishMovieRepository;

import com.bcefit.projet.service.mapper.WatchMovieMsgMapper;
import com.bcefit.projet.service.message.MessageString;
import com.bcefit.projet.service.user.IUserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class WatchMovieServiceServiceImpl implements IWatchMovieService {

    Logger logger = LoggerFactory.getLogger(WatchMovieServiceServiceImpl.class);

    @Autowired
    IWatchMovieRepository repository;

    @Autowired
    IWishMovieRepository iWishMovieRepository;

    @Autowired
    IWatchMoviesByUserAccountRepository iWatchMoviesByUserAccountRepository;

    @Autowired
    IUserAccountService iUserAccountService;

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    WatchMovieMsgMapper watchMovieMapper;


    @Override
    public Iterable<WatchMovie> findAllByUserAccountId(UserAccount userAccount) {
        Optional<List<WatchMovie>> WatchMovieList = iWatchMoviesByUserAccountRepository.findWatchMoviesByUserAccount(userAccount);
        logger.debug("service findbyId {}", userAccount.getIdUser());
        if (WatchMovieList.isPresent()) {
            return WatchMovieList.get();
        } else {
            logger.error("pas de watch movie avec l'id user {}", userAccount.getIdUser());
            throw new EntityNotFoundException("Pas de watch movie en base");
        }
    }

    @Override
    public WatchMovie findById(Long id) {
        Optional<WatchMovie> optionalWatchMovie = repository.findById(id);
        logger.debug("service findbyId {}", id);
        if (optionalWatchMovie.isPresent()) {
            return optionalWatchMovie.get();
        } else {
            logger.error("pas de watch movie avec l'id  {}", id);
            throw new EntityNotFoundException("Le watch movie n'existe pas");
        }
    }

    @Override
    public WatchMovie createWatchMovie(WatchMovie watchMovie) {
        // Enregistrement du watch Movie
        WatchMovie watchMovieAdd = repository.save(watchMovie);
        // Suppression de l'éventuel wish Movie associé

        WishMovie wishMovieToDelete = iWishMovieRepository.findByIdMovieAndUserAccount(watchMovieAdd.getMovie().getIdMovie(),watchMovieAdd.getUserAccount());
        if(wishMovieToDelete!=null){
            iWishMovieRepository.delete(wishMovieToDelete);
        }

        // Envoie d'un message pour informer de l'ajout d'un film dans la watchList
        //String message = watchMovieMapper.convertEntityToMessage(watchMovie);
        //jmsTemplate.send("Q_ADD_Watch_MOVIE", new MessageString(message));

        return watchMovieAdd;
    }

    @Override
    public void deleteWatchMovie(WatchMovie watchMovie) {
        repository.delete(watchMovie);
        // Envoie d'un message pour informer de l'ajout d'un film dans la watchList
        //String message = watchMovieMapper.convertEntityToMessage(watchMovie);
        //jmsTemplate.send("Q_DELETE_Watch_MOVIE", new MessageString(message));
    }
}
