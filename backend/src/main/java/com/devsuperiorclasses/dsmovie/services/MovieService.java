package com.devsuperiorclasses.dsmovie.services;

import java.util.List;

import com.devsuperiorclasses.dsmovie.dto.MovieDTO;
import com.devsuperiorclasses.dsmovie.entities.Movie;
import com.devsuperiorclasses.dsmovie.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Registra o MovieService como componente do sistema

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;
    // Faz a injeção de dependência

    // Colocado para que se resolva tudo da JPA nessa camada de serviço
    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<Movie> result = repository.findAll(pageable);
        Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
        return page;
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        Movie result = repository.findById(id).get();
        MovieDTO dto = new MovieDTO(result);
        return dto;
    }

}
