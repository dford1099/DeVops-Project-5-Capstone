package com.fthiago.customer.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Optional<Customer> findById(Long id);
    List<Customer> findAll();
    boolean update(Customer customer);
    Customer save(Customer customer);
    boolean delete(Long id);

}
