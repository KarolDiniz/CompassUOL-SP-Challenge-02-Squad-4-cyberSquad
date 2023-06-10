package br.com.compassuol.pb.challenge.ecommerce.api.controller;
import br.com.compassuol.pb.challenge.ecommerce.domain.entities.Customer;
import br.com.compassuol.pb.challenge.ecommerce.domain.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerControllerTest {
    @Mock
    private CustomerService customerService;

    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customerController = new CustomerController(customerService);
    }

    @Test
    void createCustomer_ValidCustomer_ReturnsCreated() {
        // Arrange
        Customer customer = new Customer();
        customer.setName("John Doe");

        when(customerService.createCustomer(customer)).thenReturn(customer);

        // Act
        ResponseEntity<Customer> response = customerController.createCustomer(customer);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(customer, response.getBody());
        verify(customerService, times(1)).createCustomer(customer);
    }

    @Test
    void getCustomerById_ExistingCustomerId_ReturnsCustomer() {
        // Arrange
        Long customerId = 1L;
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setName("John Doe");

        when(customerService.getCustomerById(customerId)).thenReturn(customer);

        // Act
        ResponseEntity<Customer> response = customerController.getCustomerById(customerId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
        verify(customerService, times(1)).getCustomerById(customerId);
    }

    @Test
    void updateCustomer_ValidCustomer_ReturnsUpdatedCustomer() {
        // Arrange
        Long customerId = 1L;
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setName("John Doe");

        when(customerService.updateCustomer(customer)).thenReturn(customer);

        // Act
        ResponseEntity<Customer> response = customerController.updateCustomer(customerId, customer);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
        verify(customerService, times(1)).updateCustomer(customer);
    }

    @Test
    void updateCustomer_CustomerIdMismatch_ThrowsIllegalArgumentException() {
        // Arrange
        Long customerId = 1L;
        Customer customer = new Customer();
        customer.setCustomerId(2L);
        customer.setName("John Doe");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            customerController.updateCustomer(customerId, customer);
        });
        verify(customerService, never()).updateCustomer(customer);
    }
}
