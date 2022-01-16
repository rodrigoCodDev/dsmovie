package com.devsuperiorclasses.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperiorclasses.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
