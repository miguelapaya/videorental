package com.sm.videorentalsystem.service;

import com.sm.videorentalsystem.entity.RentalHeader;
import com.sm.videorentalsystem.repository.RentalHeaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RentalHeaderService {


    private final RentalHeaderRepository rentalHeaderRepository;

    public RentalHeaderService(RentalHeaderRepository rentalHeaderRepository) {
        this.rentalHeaderRepository = rentalHeaderRepository;
    }

    public List<RentalHeader> getAllRentalHeaders() {
        return rentalHeaderRepository.findAll();
    }

    public RentalHeader addRentalHeader(RentalHeader rentalHeader) {
        return rentalHeaderRepository.save(rentalHeader);
    }
}
