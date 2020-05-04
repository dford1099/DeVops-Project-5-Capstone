package com.fthiago.customer;

import com.fthiago.customer.customer.Customer;
import com.fthiago.customer.customer.CustomerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @MockBean
    private CustomerService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /customers/1 - Found")
    void testGetCustomerByIdFound() throws Exception {
        Customer mockedCustomer = new Customer(1, "Customer Name", "Customer Address");
        doReturn(Optional.of(mockedCustomer)).when(service).getById(1);

        mockMvc.perform(get("/customers/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Customer Name")));
    }

    @Test
    @DisplayName("GET /customers/1 - Not Found")
    void testGetCustomerByIdNotFound() throws Exception {
        doReturn(Optional.empty()).when(service).getById(1);

        mockMvc.perform(get("/customers/{id}", 1))
                .andExpect(status().isNotFound());
    }

}
