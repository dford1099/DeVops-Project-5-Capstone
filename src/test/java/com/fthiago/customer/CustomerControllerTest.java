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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        doReturn(mockedCustomer).when(service).save(any());

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
        doReturn(Optional.of(mockedCustomer)).when(service).findById(1L);

        mockMvc.perform(get("/customers/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Customer Name")));
    }

    @Test
    @DisplayName("GET /customers/1 - Not Found")
    void testGetCustomerByIdNotFound() throws Exception {
        doReturn(Optional.empty()).when(service).findById(1L);

        mockMvc.perform(get("/customers/{id}", 1))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("DELETE /customers/1 - Success")
    void testDeleteCustomerByIdFound() throws Exception {
        Customer mockedCustomer = new Customer(1, "Customer Name", "Customer Address");

        // Mocked services
        doReturn(Optional.of(mockedCustomer)).when(service).findById(1L);
        doReturn(true).when(service).delete(1L);

        mockMvc.perform(delete("/customers/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("DELETE /customers/1 - Not Found")
    void testDeleteCustomerByIdNotFound() throws Exception {
        // Mocked services
        doReturn(Optional.of(false)).when(service).findById(1L);

        mockMvc.perform(delete("/customers/{id}", 1))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("PUT /customers/1 - Not Found")
    void testUpdateCustomerByIdNotFound() throws Exception {

        Customer putCustomer = new Customer("Customer Name Updated", "Customer Address Updated");
        Customer mockedCustomer = new Customer(1, "Customer Name", "Customer Address");
        // Mocked services
        doReturn(Optional.of(mockedCustomer)).when(service).findById(1L);

        mockMvc.perform(put("/customers/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(mockedCustomer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Customer Name")));
    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
