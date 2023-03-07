package com.bcefit.projet.exposition.watch.mapper;


import com.bcefit.projet.domain.watch.WatchEpisode;
import com.bcefit.projet.exposition.user.mapper.UserAccountMapper;
import com.bcefit.projet.exposition.watch.dto.WatchEpisodeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WatchEpisodeMapper {

    @Autowired
    UserAccountMapper userAccountMapper;
    public WatchEpisodeDto convertEntityToDto(WatchEpisode entity){
        WatchEpisodeDto dto = new WatchEpisodeDto();
        dto.setIdWatch(entity.getIdWatch());
        dto.setIdEpisode(entity.getIdEpisode());
        dto.setIdSeason(entity.getIdSeason());
        dto.setIdTv(entity.getIdTv());
        dto.setViewingPlace(entity.getViewingPlace());
        dto.setViewingMood(entity.getViewingMood());
        dto.setViewingRate(entity.getViewingRate());
        dto.setDateWatch(entity.getDateWatch());
        dto.setDuration(entity.getDuration());
        return dto;
    }

    public WatchEpisode convertDtoToEntity(WatchEpisodeDto dto){
        WatchEpisode entity = new WatchEpisode();
        entity.setIdWatch(dto.getIdWatch());
        entity.setIdEpisode(dto.getIdEpisode());
        entity.setIdSeason(dto.getIdSeason());
        entity.setIdTv(dto.getIdTv());
        entity.setViewingMood(dto.getViewingMood());
        entity.setViewingRate(dto.getViewingRate());
        entity.setViewingPlace(dto.getViewingPlace());
        entity.setDateWatch(dto.getDateWatch());
        entity.setDuration(dto.getDuration());
        return entity;
    }

    public List<WatchEpisode> convertListDtoToEntity(List<WatchEpisodeDto> dtoList){
        List<WatchEpisode> entityList = new ArrayList<>();
        for(WatchEpisodeDto dto : dtoList){
            entityList.add(convertDtoToEntity(dto));
        }
        return entityList;
    }

    public List<WatchEpisodeDto> convertListEntityToDto(List<WatchEpisode> entityList){
        List<WatchEpisodeDto> dtoList = new ArrayList<>();
        for(WatchEpisode entity : entityList){
            dtoList.add(convertEntityToDto(entity));
        }
        return dtoList;
    }

}
