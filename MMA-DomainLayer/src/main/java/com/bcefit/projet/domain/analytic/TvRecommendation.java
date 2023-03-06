package com.bcefit.projet.domain.analytic;


import com.bcefit.projet.domain.user.GenreTv;

import javax.persistence.*;

@Entity
@Table(name = "tv_recommendation")
public class TvRecommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Integer IdTv;

    @ManyToOne
    @JoinColumn(name = "genre_tv_id")
    private GenreTv genreTv;

    public GenreTv getGenreTv() {
        return genreTv;
    }

    public void setGenreTv(GenreTv genreTv) {
        this.genreTv = genreTv;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
