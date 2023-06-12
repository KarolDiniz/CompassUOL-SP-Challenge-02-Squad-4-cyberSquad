package br.com.compassuol.pb.challenge.ecommerce.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

/**
 * Represents a customer in the e-commerce system.
 * This class encapsulates the data related to a customer, including his name, CPF, email, and activation status.
 */

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long customerId;

    @Column(name = "name")
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;

    @Column(name = "cpf", unique = true)
    @CPF(message = "Invalid CPF")
    private String cpf;

    @Column(name = "email", unique = true)
    @Email(message = "Invalid email address")
    private String email;

    @Column(name = "active")
    private boolean active;
}

