package com.sm.videorentalsystem.service;

import com.sm.videorentalsystem.entity.Movie;
import com.sm.videorentalsystem.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(int id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getAvailableMovies() {
        return movieRepository.findAvailableMovies();
    }

    public List<Movie> getUnavailableMovies() {
        return movieRepository.findUnavailableMovies();
    }
}
