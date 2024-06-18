package com.sm.videorentalsystem.controller;

import com.sm.videorentalsystem.entity.Movie;
import com.sm.videorentalsystem.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(value = "", consumes = "application/json")
    public Movie saveMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @GetMapping("")
    public List<Movie> getMovies(@RequestParam(required = false) String availability) {
        if (availability == null) {
            return movieService.getAllMovies();
        } else if ("available".equalsIgnoreCase(availability)) {
            return movieService.getAvailableMovies();
        } else if ("unavailable".equalsIgnoreCase(availability)) {
            return movieService.getUnavailableMovies();
        } else {
            return movieService.getAllMovies();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        return ResponseEntity.of(movieService.getMovieById(id));
    }
}
