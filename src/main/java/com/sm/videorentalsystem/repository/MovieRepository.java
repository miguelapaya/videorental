package com.sm.videorentalsystem.repository;

import com.sm.videorentalsystem.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT m FROM Movie m WHERE m.numberAvailable > 0")
    List<Movie> findAvailableMovies();

    @Query("SELECT m FROM Movie m WHERE m.numberAvailable = 0")
    List<Movie> findUnavailableMovies();
}
