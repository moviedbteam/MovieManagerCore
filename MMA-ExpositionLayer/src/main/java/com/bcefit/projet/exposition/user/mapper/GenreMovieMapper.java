package com.bcefit.projet.exposition.user.mapper;

import com.bcefit.projet.domain.user.GenreMovie;
import com.bcefit.projet.exposition.user.dto.GenreMovieDto;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class GenreMovieMapper {

    public GenreMovieDto convertEntityToDto(GenreMovie entity){
        return new GenreMovieDto(entity.getId(), entity.getName());
    }

    public GenreMovie convertDtoToEntity(GenreMovieDto dto){
        GenreMovie entity = new GenreMovie();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public Set<GenreMovie> convertListDtoToEntity(Set<GenreMovieDto> dtoSet){
        Set<GenreMovie> entitySet = new HashSet<>();
        for(GenreMovieDto dto:dtoSet){
            entitySet.add(convertDtoToEntity(dto));
        }
        return entitySet;
    }



    public Set<GenreMovieDto> convertListEntityToDto(Set<GenreMovie> entitySet) {
        Set<GenreMovieDto> dtoSet = new HashSet<>();
        for (GenreMovie entity : entitySet) {
            dtoSet.add(convertEntityToDto(entity));
        }
        return dtoSet;
    }

}
