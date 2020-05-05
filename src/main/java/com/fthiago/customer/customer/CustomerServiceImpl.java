package com.fthiago.customer.customer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
