package com.sm.videorentalsystem.controller;

import com.sm.videorentalsystem.entity.RentalHeader;
import com.sm.videorentalsystem.service.RentalHeaderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentalheader")
public class RentalHeaderController {

    private final RentalHeaderService rentalHeaderService;

    public RentalHeaderController(RentalHeaderService rentalHeaderService){
        this.rentalHeaderService = rentalHeaderService;
    }

    @GetMapping("")
    public List<RentalHeader> getAllRentalHeaders() {
        return rentalHeaderService.getAllRentalHeaders();
    }

    @PostMapping(value = "", consumes = "application/json")
    public RentalHeader createRentalHeader(@RequestBody RentalHeader rentalHeader) {
        return rentalHeaderService.addRentalHeader(rentalHeader);
    }


}
