package br.com.compassuol.pb.challenge.ecommerce.domain.repository;

import br.com.compassuol.pb.challenge.ecommerce.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> { }

