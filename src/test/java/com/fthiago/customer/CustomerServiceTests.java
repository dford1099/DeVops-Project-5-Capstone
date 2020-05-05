package com.fthiago.customer;

import com.fthiago.customer.customer.Customer;
import com.fthiago.customer.customer.CustomerRepository;
import com.fthiago.customer.customer.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CustomerServiceTests {

    @Autowired
    private CustomerService service;

    @MockBean
    private CustomerRepository repository;

    @Test
    @DisplayName("FindById - Success")
    void testFindByIdSuccess() {
        //SetUp Mock
        Customer mockCustomer = new Customer(1, "Customer Name", "Customer Address");
        doReturn(Optional.of(mockCustomer)).when(repository).findById(1L);

        Optional<Customer> returnedProduct = service.findById(1L);

        Assertions.assertTrue(returnedProduct.isPresent(), "Customer was not found");
        Assertions.assertSame(returnedProduct.get(), mockCustomer, "Customers should be the same");
    }

}
