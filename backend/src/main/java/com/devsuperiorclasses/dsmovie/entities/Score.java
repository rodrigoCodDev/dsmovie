package com.devsuperiorclasses.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score {

    // Chave composta do Score
    @EmbeddedId
    private ScorePK id = new ScorePK();
    private Double value;

    public Score() {

    }

    public ScorePK getId() {
        return id;
    }

    public void setMovie(Movie movie) {
        id.setMovie(movie);
    }

    public void setUser(User user) {
        id.setUser(user);
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
