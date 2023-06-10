package br.com.compassuol.pb.challenge.ecommerce.domain.repository;
import br.com.compassuol.pb.challenge.ecommerce.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(Long customerId);
}