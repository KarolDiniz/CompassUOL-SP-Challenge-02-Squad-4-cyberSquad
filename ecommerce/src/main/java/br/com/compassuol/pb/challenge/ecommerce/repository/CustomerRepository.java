package br.com.compassuol.pb.challenge.ecommerce.repository;

import br.com.compassuol.pb.challenge.ecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interface representa o repositório dos clientes, responsável por interagir com a persistência.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> { }

