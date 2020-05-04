package com.fthiago.customer.customer;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    public Optional<Customer> createCustomer(Customer customer) {
        return Optional.empty();
    }

    public Optional<Customer> getById(long id) {
        return Optional.empty();
    }

    public Optional<Customer> save(Customer customer) {
        return Optional.empty();
    }

    public boolean delete(long id) {
        return true;
    }
}
