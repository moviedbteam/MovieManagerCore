package com.bcefit.projet.infrastructure;

import com.bcefit.projet.domain.user.GenreMovie;
import com.bcefit.projet.domain.user.GenreTv;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IGenreTvRepository extends CrudRepository<GenreTv, Long> {

    //List<GenreTv> findGenreMoviesByUserAccountSet(Long idUser);
}
