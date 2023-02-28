package com.bcefit.projet.service.watch;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.domain.watch.WatchEpisode;
import com.bcefit.projet.infrastructure.IWatchEpisodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class WatchEpisodeServiceImpl implements IWatchEpisodeService {

    Logger logger = LoggerFactory.getLogger(WatchEpisodeServiceImpl.class);

    @Autowired
    IWatchEpisodeRepository repository;

    @Autowired
    JmsTemplate jmsTemplate;

    @Override
    public Iterable<WatchEpisode> findAllByUserAccountId(UserAccount userAccount) {
        Optional<List<WatchEpisode>> watchEpisodeList = repository.findWatchEpisodesByUserAccount(userAccount.getIdUser());
        logger.debug("service findbyId {}", userAccount.getIdUser());
        if (watchEpisodeList.isPresent()) {
            return watchEpisodeList.get();
        } else {
            logger.error("pas de watch episode avec l'id user {}", userAccount.getIdUser());
            throw new EntityNotFoundException("Pas de watch episode en base");
        }
    }

    @Override
    public WatchEpisode findById(Long id) {
        Optional<WatchEpisode> optionalWatchEpisode = repository.findById(id);
        logger.debug("service findbyId {}", id);
        if (optionalWatchEpisode.isPresent()) {
            return optionalWatchEpisode.get();
        } else {
            logger.error("pas de watch episode avec l'id  {}", id);
            throw new EntityNotFoundException("Le watch episode n'existe pas");
        }
    }

    @Override
    public WatchEpisode createWatchEpisode(WatchEpisode watchEpisode) {
        return repository.save(watchEpisode);
        // Envoie d'un message pour informer de l'ajout d'un episode dans la watchList
        //jmsTemplate.send("Q_ADD_Watch_EPISODE", new MessageString(watchEpisode.getUid()));
    }

    @Override
    public void deleteWatchEpisode(WatchEpisode watchEpisode) {
        repository.delete(watchEpisode);
        // Envoie d'un message pour informer de la suppression d'un film dans la watchList
        //jmsTemplate.send("Q_DELETE_Watch_EPISODE", new MessageString(watchEpisode.toString()));
    }
}
