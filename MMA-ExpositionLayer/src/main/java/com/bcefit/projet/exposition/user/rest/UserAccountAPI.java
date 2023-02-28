package com.bcefit.projet.exposition.user.rest;

import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.exposition.user.dto.UserAccountDto;
import com.bcefit.projet.exposition.user.mapper.UserAccountMapper;
import com.bcefit.projet.service.common.ILogginService;
import com.bcefit.projet.service.user.IUserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/userAccount")
public class UserAccountAPI {

    @Autowired
    ILogginService logginService;

    @Autowired
    IUserAccountService service;

    @Autowired
    UserAccountMapper mapper;

    Logger logger = LoggerFactory.getLogger(UserAccountAPI.class);

    @GetMapping("/{idUser}")
    public UserAccountDto getUserAccountById(@RequestAttribute("userLoggin") String userLoggin){
        logger.info("Nouvelle demande pour le UserAccount (loggin) {}", userLoggin);
        Long idUser = logginService.getIdUserByUserLoggin(userLoggin);
        UserAccount userAccount = service.findById(idUser);
        logger.debug("DEBUG---ID UserAccount = {}", userAccount.getIdUser());
        return mapper.convertEntityToDto(userAccount);
    }

    @PostMapping("/create")
    public ResponseEntity<UserAccountDto> create(@RequestBody UserAccountDto userAccountDto, @RequestAttribute("userLoggin") String userLoggin){

        logger.info("enregistrement d'un nouveau user account {}",userAccountDto.getUserName());

        UserAccount userAccount=mapper.convertDtoToEntity(userAccountDto);

        UserAccountDto dto=mapper.convertEntityToDto(service.createUserAccount(userAccount));

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PostMapping("/update")
    public ResponseEntity<UserAccountDto> update(@RequestBody UserAccountDto userAccountDto, @RequestAttribute("userLoggin") String userLoggin){
        logger.info("Nouvelle demande pour le UserAccount (loggin) {}", userLoggin);
        Long idUser = logginService.getIdUserByUserLoggin(userLoggin);
        userAccountDto.setIdUser(idUser);
        logger.info("modification du user account {}",userAccountDto.getUserName());

        UserAccount userAccount=mapper.convertDtoToEntity(userAccountDto);

        UserAccountDto dto=mapper.convertEntityToDto(service.updateUserAccount(userAccount));

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserAccountDto>> getAllUserAccounts(){
        logger.info("nouvelle demande de liste de user Account");
        Iterable<UserAccount> iterable=service.findAll();
        List<UserAccountDto> userAccountDtoList=new ArrayList<>();

        iterable.forEach((pEntity)-> userAccountDtoList.add(mapper.convertEntityToDto(pEntity)));

        return ResponseEntity.status(HttpStatus.OK).body(userAccountDtoList);
    }
}
