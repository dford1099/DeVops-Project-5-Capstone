package com.fthiago.customer.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {
    public Optional<Customer> findById(Long id) {
        return null;
    }

    public List<Customer> findAll() {
        return null;
    }

    public boolean update(Customer customer) {
        return false;
    }

    public Customer save(Customer customer) {
        return null;
    }
}
