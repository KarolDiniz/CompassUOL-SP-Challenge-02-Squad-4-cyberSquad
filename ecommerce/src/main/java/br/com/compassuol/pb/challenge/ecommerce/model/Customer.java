package br.com.compassuol.pb.challenge.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter @Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "name")
    @Size(min = 3)
    private String name;

    @Column(name = "cpf", unique = true)
    @CPF
    private String cpf;

    @Column(name = "email", unique = true)
    @Email
    private String email;

    @Column(name = "active")
    private Boolean active;

}

