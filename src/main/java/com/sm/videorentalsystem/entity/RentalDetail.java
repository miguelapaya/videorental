package com.sm.videorentalsystem.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class RentalDetail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentalDetailId;

    @ManyToOne
    @JoinColumn(name = "rentalId")
    private RentalHeader rentalHeader;

    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;

    private LocalDateTime dateReturned;

    public int getRentalDetailId() {
        return rentalDetailId;
    }

    public void setRentalDetailId(int rentalDetailId) {
        this.rentalDetailId = rentalDetailId;
    }

    public RentalHeader getRentalHeader() {
        return rentalHeader;
    }

    public void setRentalHeader(RentalHeader rentalHeader) {
        this.rentalHeader = rentalHeader;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(LocalDateTime dateReturned) {
        this.dateReturned = dateReturned;
    }
}
