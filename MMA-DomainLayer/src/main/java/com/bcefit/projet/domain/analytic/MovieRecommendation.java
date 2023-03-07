package com.bcefit.projet.domain.analytic;


import com.bcefit.projet.domain.user.GenreMovie;
import com.bcefit.projet.domain.user.UserAccount;

import javax.persistence.*;

@Entity
@Table(name = "movie_recommendation")
public class MovieRecommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UserAccount userAccount;

    private Integer idMovie;

    private Double popularity;



    @ManyToOne
    @JoinColumn(name = "genre_movie_id")
    private GenreMovie genreMovie;

    public GenreMovie getGenreMovie() {
        return genreMovie;
    }

    public void setGenreMovie(GenreMovie genreMovie) {
        this.genreMovie = genreMovie;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
