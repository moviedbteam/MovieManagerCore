package com.bcefit.projet.service.user;

import com.bcefit.projet.domain.user.UserAccount;

public interface IUserAccountService {

    UserAccount findById(Long idUser);

    UserAccount createUserAccount(UserAccount userAccount);


    void deleteUserAccount(UserAccount userAccount);

    UserAccount updateUserAccount(UserAccount userAccount);

    Iterable<UserAccount> findAll();
}
