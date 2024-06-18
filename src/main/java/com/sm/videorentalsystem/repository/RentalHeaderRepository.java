package com.sm.videorentalsystem.repository;

import com.sm.videorentalsystem.entity.RentalHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalHeaderRepository extends JpaRepository<RentalHeader, Integer> {
}
