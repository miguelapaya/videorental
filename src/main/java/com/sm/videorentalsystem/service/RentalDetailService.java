package com.sm.videorentalsystem.service;

import com.sm.videorentalsystem.entity.Movie;
import com.sm.videorentalsystem.entity.RentalDetail;
import com.sm.videorentalsystem.entity.RentalHeader;
import com.sm.videorentalsystem.repository.MovieRepository;
import com.sm.videorentalsystem.repository.RentalDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalDetailService {

    private final RentalDetailRepository rentalDetailRepository;
    private final MovieRepository movieRepository;

    public RentalDetailService(RentalDetailRepository rentalDetailRepository, MovieRepository movieRepository){
        this.rentalDetailRepository = rentalDetailRepository;
        this.movieRepository = movieRepository;
    }

    public RentalDetail saveRentals(RentalDetail rentalDetail) {
        Integer movieId = rentalDetail.getMovie().getMovieId();
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new IllegalArgumentException("Movie not found" + movieId));

        int currentNumberAvailable = movie.getNumberAvailable();
        int currentStock = movie.getNumberInStock();

        if (currentNumberAvailable <= 0) {
            throw new IllegalArgumentException("Movie is not available for rent");
        }
        movie.setNumberAvailable(currentNumberAvailable - 1);
        movie.setNumberInStock(currentStock - 1);
        movieRepository.save(movie);


        return rentalDetailRepository.save(rentalDetail);
    }

    public List<RentalDetail> getAllRentals() {
        return rentalDetailRepository.findAll();
    }

    public List<RentalDetail> getRentalDetailsByCustomerName(String customerName) {
        return rentalDetailRepository.findByCustomerName(customerName);
    }

    public Optional<RentalDetail> updateRentalDetail(int id, RentalDetail rentalDetail) {
        return rentalDetailRepository.findById(id).map(existingRentalDetail -> {
            existingRentalDetail.setRentalHeader(rentalDetail.getRentalHeader());
            existingRentalDetail.setMovie(rentalDetail.getMovie());
            existingRentalDetail.setDateReturned(rentalDetail.getDateReturned());
            return rentalDetailRepository.save(existingRentalDetail);
        });
    }
}
