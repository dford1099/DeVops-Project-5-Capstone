package com.fthiago.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fthiago.customer.customer.Customer;
import com.fthiago.customer.customer.CustomerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    @DisplayName("POST /customers - Success")
    void testPostNewCustomer() throws Exception {
        Customer postCustomer = new Customer("Customer Name", "Customer Address");
        Customer mockedCustomer = new Customer(1, "Customer Name", "Customer Address");
        doReturn(Optional.of(mockedCustomer)).when(service).save(any());

        mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(postCustomer)))

                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Customer Name")))
                .andExpect(jsonPath("$.address", is("Customer Address")));
    }

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

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
