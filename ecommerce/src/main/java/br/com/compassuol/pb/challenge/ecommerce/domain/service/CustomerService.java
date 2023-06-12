package br.com.compassuol.pb.challenge.ecommerce.domain.service;

import br.com.compassuol.pb.challenge.ecommerce.domain.entities.Customer;
import br.com.compassuol.pb.challenge.ecommerce.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * Manages operations related to clients.
 * Uses a CustomerRepository to interact with the persistence layer
 */

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
