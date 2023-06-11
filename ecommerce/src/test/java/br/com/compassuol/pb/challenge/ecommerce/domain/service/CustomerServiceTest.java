package br.com.compassuol.pb.challenge.ecommerce.domain.service;

import br.com.compassuol.pb.challenge.ecommerce.domain.entities.Customer;
import br.com.compassuol.pb.challenge.ecommerce.domain.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customerService = new CustomerService(customerRepository);
    }

    @Test
    void createCustomer() {
        Customer customer = new Customer();
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer createdCustomer = customerService.createCustomer(customer);

        assertNotNull(createdCustomer);
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void getCustomerById_ExistingCustomer_ReturnsCustomer() {
        Long customerId = 1L;
        Customer customer = new Customer();
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        Customer retrievedCustomer = customerService.getCustomerById(customerId);

        assertNotNull(retrievedCustomer);
        verify(customerRepository, times(1)).findById(customerId);
    }

    @Test
    void getCustomerById_NonExistingCustomer_ThrowsNoSuchElementException() {
        Long customerId = 1L;
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> customerService.getCustomerById(customerId));
        verify(customerRepository, times(1)).findById(customerId);
    }

    @Test
    void updateCustomer() {
        Customer customer = new Customer();
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer updatedCustomer = customerService.updateCustomer(customer);

        assertNotNull(updatedCustomer);
        verify(customerRepository, times(1)).save(customer);
    }
}
