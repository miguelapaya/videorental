package com.sm.videorentalsystem.service;

import com.sm.videorentalsystem.entity.Customer;
import com.sm.videorentalsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        LocalDate today = LocalDate.now();
        LocalDate bday = customer.getBirthDate();

        if(customer.getBirthDate() == null) {
            throw new IllegalArgumentException("Customer birthdate is required");
        }

        Period period = Period.between(bday, today);

        if(period.getYears() > 13) {
            return customerRepository.save(customer);
        } else {
            throw new IllegalArgumentException("Customer must above 13 y/o");
        }
    }
}
