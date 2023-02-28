package com.bcefit.projet.service.wish;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.wish.WishEpisode;
import com.bcefit.projet.infrastructure.IWishEpisodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class WishEpisodeServiceImpl implements IWishEpisodeService{

    Logger logger = LoggerFactory.getLogger(WishEpisodeServiceImpl.class);

    @Autowired
    IWishEpisodeRepository repository;

    @Autowired
    JmsTemplate jmsTemplate;

    @Override
    public Iterable<WishEpisode> findAllByUserAccountId(UserAccount userAccount) {
        Optional<List<WishEpisode>> wishEpisodeList = repository.findWishEpisodesByUserAccount(userAccount.getIdUser());
        logger.debug("service findbyId {}", userAccount.getIdUser());
        if (wishEpisodeList.isPresent()) {
            return wishEpisodeList.get();
        } else {
            logger.error("pas de wish episode avec l'id user {}", userAccount.getIdUser());
            throw new EntityNotFoundException("Pas de wish episode en base");
        }
    }

    @Override
    public WishEpisode findById(Long id) {
        Optional<WishEpisode> optionalWishEpisode = repository.findById(id);
        logger.debug("service findbyId {}", id);
        if (optionalWishEpisode.isPresent()) {
            return optionalWishEpisode.get();
        } else {
            logger.error("pas de wish episode avec l'id  {}", id);
            throw new EntityNotFoundException("Le wish episode n'existe pas");
        }
    }

    @Override
    public WishEpisode createWishEpisode(WishEpisode wishEpisode) {
        return repository.save(wishEpisode);
        // Envoie d'un message pour informer de l'ajout d'un episode dans la wishList
        //jmsTemplate.send("Q_ADD_Wish_EPISODE", new MessageString(wishEpisode.getUid()));
    }

    @Override
    public void deleteWishEpisode(WishEpisode wishEpisode) {
        repository.delete(wishEpisode);
        // Envoie d'un message pour informer de la suppression d'un film dans la wishList
        //jmsTemplate.send("Q_DELETE_Wish_EPISODE", new MessageString(wishEpisode.toString()));
    }
}
