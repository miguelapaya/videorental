package com.sm.videorentalsystem.controller;

import com.sm.videorentalsystem.entity.RentalDetail;
import com.sm.videorentalsystem.service.RentalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalDetailsController {

    private final RentalDetailService rentalDetailService;

    public RentalDetailsController(RentalDetailService rentalDetailService) {
        this.rentalDetailService = rentalDetailService;
    }

    @PostMapping(value = "", consumes = "application/json")
    public RentalDetail saveRentals(@RequestBody  RentalDetail rentalDetail) {
        return rentalDetailService.saveRentals(rentalDetail);
    }

    @GetMapping("")
    public List<RentalDetail> getAllRentals() {
        return rentalDetailService.getAllRentals();
    }

    @GetMapping("/rental")
    public List<RentalDetail> getRentalDetailsByCustomerName(@RequestParam String customerName) {
        return rentalDetailService.getRentalDetailsByCustomerName(customerName);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalDetail> updateRentalDetail(@PathVariable int id, @RequestBody RentalDetail rentalDetail) {
        return ResponseEntity.of(rentalDetailService.updateRentalDetail(id, rentalDetail));
    }
}
