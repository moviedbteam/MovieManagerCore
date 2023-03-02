package com.bcefit.projet.infrastructure;

import com.bcefit.projet.domain.wish.WishMovie;
import org.springframework.data.repository.CrudRepository;


public interface IWishMovieRepository extends CrudRepository<WishMovie , Long> {


}
