package com.devsuperiorclasses.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperiorclasses.dsmovie.entities.Score;
import com.devsuperiorclasses.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
