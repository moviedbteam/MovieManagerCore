package com.bcefit.projet.infrastructure;

import com.bcefit.projet.domain.analytic.TvRecommendation;
import com.bcefit.projet.domain.moviedb.Movie;
import com.bcefit.projet.domain.moviedb.Tv;
import com.bcefit.projet.domain.user.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ITvRecommendationRepository extends CrudRepository<TvRecommendation, Long> {
    @Query("select t from TvRecommendation t where t.userAccount = ?1 and t.tv = ?2")
    TvRecommendation findByUserAccountAndTv(UserAccount userAccount, Tv tv);
    long deleteByUserAccountAndTv(UserAccount userAccount, Tv tv);
    long deleteByTv(Tv tv);
}
