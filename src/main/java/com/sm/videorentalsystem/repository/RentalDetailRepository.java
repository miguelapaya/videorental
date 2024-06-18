package com.sm.videorentalsystem.repository;

import com.sm.videorentalsystem.entity.RentalDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalDetailRepository extends JpaRepository<RentalDetail, Integer> {

    @Query("SELECT rd FROM RentalDetail rd JOIN rd.rentalHeader rh JOIN rh.customer c WHERE c.customerName = :customerName")
    List<RentalDetail> findByCustomerName(@Param("customerName") String customerName);
}
