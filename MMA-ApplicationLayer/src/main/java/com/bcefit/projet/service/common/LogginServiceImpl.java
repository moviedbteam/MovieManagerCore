package com.bcefit.projet.service.common;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.infrastructure.ILogginRepository;
import com.bcefit.projet.service.user.UserAccountServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;


@Service
public class LogginServiceImpl implements ILogginService {

    @Autowired
    ILogginRepository repository;

    Logger logger = LoggerFactory.getLogger(LogginServiceImpl.class);

    @Override
    public Long getIdUserByUserLoggin(String userLoggin) {
        logger.debug("service getUserIdByLoggin {}", userLoggin);
        Optional<UserAccount> optionalUserAccount = repository.findUserAccountByLoggin(userLoggin);
        if(optionalUserAccount.isPresent()){
            return optionalUserAccount.get().getIdUser();
        }else{
            logger.error("pas d'idUser pour le loggin {}", userLoggin);
            throw new EntityNotFoundException("L'idUser n'éxiste pas");
        }

    }
}
