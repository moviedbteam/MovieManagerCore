package com.bcefit.projet.service.wish;


import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.wish.WishMovie;
import com.bcefit.projet.infrastructure.IWishMovieRepository;
import com.bcefit.projet.infrastructure.IWishMoviesByUserAccountRepository;
import com.bcefit.projet.service.message.MessageString;
import com.bcefit.projet.service.user.IUserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WishMovieServiceServiceImpl implements IWishMovieService{

    Logger logger = LoggerFactory.getLogger(WishMovieServiceServiceImpl.class);

    @Autowired
    IWishMovieRepository repository;

    @Autowired
    IWishMoviesByUserAccountRepository iWishMoviesByUserAccountRepository;

    @Autowired
    IUserAccountService iUserAccountService;

    @Autowired
    JmsTemplate jmsTemplate;


    @Override
    public Iterable<WishMovie> findAllByUserAccountId(UserAccount userAccount) {
        Optional<List<WishMovie>> wishMovieList = iWishMoviesByUserAccountRepository.findWishMoviesByUserAccount(userAccount);
        logger.debug("service findbyId {}", userAccount.getIdUser());
        if (wishMovieList.isPresent()) {
            return wishMovieList.get();
        } else {
            logger.error("pas de wish movie avec l'id user {}", userAccount.getIdUser());
            throw new EntityNotFoundException("Pas de wish movie en base");
        }
    }

    @Override
    public WishMovie findById(Long id) {
        Optional<WishMovie> optionalWishMovie = repository.findById(id);
        logger.debug("service findbyId {}", id);
        if (optionalWishMovie.isPresent()) {
            return optionalWishMovie.get();
        } else {
            logger.error("pas de wish movie avec l'id  {}", id);
            throw new EntityNotFoundException("Le wish movie n'existe pas");
        }
    }

    @Override
    public WishMovie createWishMovie(WishMovie wishMovie) {
        LocalDate actualDate = LocalDate.now();
        wishMovie.setDateWsih(actualDate);
        WishMovie wishMovieAdd = repository.save(wishMovie);
        // Envoie d'un message pour informer de l'ajout d'un film dans la wishList
        //jmsTemplate.send("Q_ADD_Wish_MOVIE", new MessageString(wishMovie.toString()));

        return repository.save(wishMovie);
    }

    @Override
    public void deleteWishMovie(WishMovie wishMovie) {
        repository.delete(wishMovie);
        // Envoie d'un message pour informer de la suppression d'un film dans la wishList
        //jmsTemplate.send("Q_DELETE_Wish_MOVIE", new MessageString(wishMovie.toString()));
    }

}
