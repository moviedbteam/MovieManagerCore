package com.bcefit.projet.infrastructure;

import com.bcefit.projet.domain.wish.WishMovie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IWishMovieRepository extends CrudRepository<WishMovie , Long> {


}
