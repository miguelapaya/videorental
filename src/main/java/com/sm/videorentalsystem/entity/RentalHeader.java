package com.sm.videorentalsystem.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class RentalHeader {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentalId;

    private LocalDateTime dateRented;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

//    @OneToMany(mappedBy = "rentalHeader", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<RentalDetail> rentalDetails;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        modifiedDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedDate = LocalDateTime.now();
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public LocalDateTime getDateRented() {
        return dateRented;
    }

    public void setDateRented(LocalDateTime dateRented) {
        this.dateRented = dateRented;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

//    public List<RentalDetail> getRentalDetails() {
//        return rentalDetails;
//    }
//
//    public void setRentalDetails(List<RentalDetail> rentalDetails) {
//        this.rentalDetails = rentalDetails;
//    }
}
