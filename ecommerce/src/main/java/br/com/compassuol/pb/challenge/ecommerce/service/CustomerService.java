package br.com.compassuol.pb.challenge.ecommerce.service;

import br.com.compassuol.pb.challenge.ecommerce.model.Customer;
import br.com.compassuol.pb.challenge.ecommerce.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * Esta classe gerencia as operações relacionadas aos clientes.
 * O serviço depende de uma instância de CustomerRepository para interagir com a camada de persistência.
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
