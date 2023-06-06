package br.com.compassuol.pb.challenge.ecommerce.controller;

import br.com.compassuol.pb.challenge.ecommerce.model.Customer;
import br.com.compassuol.pb.challenge.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsável para lidar com as requisições relacionadas aos clientes.
 * Nele, pode-se realizar operacões como: criar (Post), obter (Get) e atualizar (Put) um cliente especifico.
 */
@RestController
@RequestMapping("/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable("id") Long customerId, @RequestBody @Valid Customer customer) {
        if (!customerId.equals(customer.getCustomerId())) {
            throw new IllegalArgumentException("Customer ID mismatch");
        }
        Customer updatedCustomer = customerService.updateCustomer(customer);
        return ResponseEntity.ok(updatedCustomer);
    }
}

