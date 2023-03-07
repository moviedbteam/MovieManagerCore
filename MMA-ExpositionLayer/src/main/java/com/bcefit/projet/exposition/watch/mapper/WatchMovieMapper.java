package com.bcefit.projet.exposition.watch.mapper;

import com.bcefit.projet.domain.watch.WatchMovie;
import com.bcefit.projet.exposition.user.mapper.UserAccountMapper;
import com.bcefit.projet.exposition.watch.dto.WatchMovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WatchMovieMapper {

    @Autowired
    UserAccountMapper userAccountMapper;

    public WatchMovieDto convertEntityToDto(WatchMovie entity){
        WatchMovieDto dto = new WatchMovieDto();
        dto.setIdWatch(entity.getIdWatch());
        dto.setViewingPlace(entity.getViewingPlace());
        dto.setViewingMood(entity.getViewingMood());
        dto.setViewingRate(entity.getViewingRate());
        dto.setIdMovie(entity.getIdMovie());
        dto.setIdCollection(entity.getIdCollection());
        dto.setDuration(entity.getDuration());
        return dto;
    }

    public WatchMovie convertDtoToEntity(WatchMovieDto dto){
        WatchMovie entity = new WatchMovie();
        entity.setIdWatch(dto.getIdWatch());
        entity.setIdMovie(dto.getIdMovie());
        entity.setIdCollection(dto.getIdCollection());
        entity.setViewingMood(dto.getViewingMood());
        entity.setViewingRate(dto.getViewingRate());
        entity.setViewingPlace(dto.getViewingPlace());
        entity.setDateWatch(dto.getDateWatch());
        entity.setDuration(dto.getDuration());
        return entity;
    }

    public List<WatchMovie> convertListDtoToEntity(List<WatchMovieDto> dtoList){
        List<WatchMovie> entityList = new ArrayList<>();
        for(WatchMovieDto dto : dtoList){
            entityList.add(convertDtoToEntity(dto));
        }
        return entityList;
    }

    public List<WatchMovieDto> convertListEntityToDto(List<WatchMovie> entityList){
        List<WatchMovieDto> dtoList = new ArrayList<>();
        for(WatchMovie entity : entityList){
            dtoList.add(convertEntityToDto(entity));
        }
        return dtoList;
    }
}
