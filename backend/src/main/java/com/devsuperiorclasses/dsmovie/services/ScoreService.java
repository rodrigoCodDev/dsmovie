package com.devsuperiorclasses.dsmovie.services;

import java.util.List;

import com.devsuperiorclasses.dsmovie.dto.MovieDTO;
import com.devsuperiorclasses.dsmovie.dto.ScoreDTO;
import com.devsuperiorclasses.dsmovie.entities.Movie;
import com.devsuperiorclasses.dsmovie.entities.Score;
import com.devsuperiorclasses.dsmovie.entities.User;
import com.devsuperiorclasses.dsmovie.repositories.MovieRepository;
import com.devsuperiorclasses.dsmovie.repositories.ScoreRepository;
import com.devsuperiorclasses.dsmovie.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Registra o MovieService como componente do sistema

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {
        // O DTO nesse caso será responsável por pegar os dados da requisição

        User user = userRepository.findByEmail(dto.getEmail());

        if (user == null) {
            user = new User();
            user.setEmail(dto.getEmail());

            // Salva usuário no banco de dados
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        // Salva score no banco de dados
        score = scoreRepository.saveAndFlush(score);

        double sum = 0;
        for (Score s : movie.getScores()) {
            sum += s.getValue();
        }

        // Faz a média das avaliações
        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return (new MovieDTO(movie));
    }
}
