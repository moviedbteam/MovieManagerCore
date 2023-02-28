package com.bcefit.projet.exposition.user.mapper;


import com.bcefit.projet.domain.user.UserAccount;
import com.bcefit.projet.exposition.user.dto.UserAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserAccountMapper {

    @Autowired
    GenreMovieMapper movieMapper;
    @Autowired
    GenreTvMapper tvMapper;

    @Autowired
    StreamingSubscriptionMapper streamingSubscriptionMapper;



    public UserAccountDto convertEntityToDto(UserAccount entity){
        UserAccountDto dto = new UserAccountDto();
        dto.setLoggin(entity.getLoggin());
        dto.setIdUser(entity.getIdUser());
        dto.setUserName(entity.getUserName());
        dto.setAdultContent(entity.isAdultContent());
        dto.setEmail(entity.getEmail());
        dto.setEnableAccount(entity.isEnableAccount());
        dto.setBirthYear(entity.getBirthYear());
        dto.setGenreMovieDtoSet(movieMapper.convertListEntityToDto(entity.getGenreMovieSet()));
        dto.setGenreTvDtoSet(tvMapper.convertListEntityToDto(entity.getGenreTvSet()));
        dto.setStreamingSubscriptionDtoSet(streamingSubscriptionMapper.convertListEntityToDto(entity.getStreamingSubscriptionSet()));
        return dto;
    }

    public UserAccount convertDtoToEntity(UserAccountDto dto){
        UserAccount entity = new UserAccount();
        entity.setLoggin(dto.getLoggin());
        entity.setIdUser(dto.getIdUser());
        entity.setUserName(dto.getUserName());
        entity.setAdultContent(dto.isAdultContent());
        entity.setEmail(dto.getEmail());
        entity.setEnableAccount(dto.isEnableAccount());
        entity.setBirthYear(dto.getBirthYear());
        entity.setGenreMovieSet(movieMapper.convertListDtoToEntity(dto.getGenreMovieDtoSet()));
        entity.setGenreTvSet(tvMapper.convertListDtoToEntity(dto.getGenreTvDtoSet()));
        entity.setStreamingSubscriptionSet(streamingSubscriptionMapper.convertListDtoToEntity(dto.getStreamingSubscriptionDtoSet()));
        return entity;
    }


}
