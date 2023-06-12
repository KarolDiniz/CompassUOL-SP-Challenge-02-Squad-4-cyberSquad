package br.com.compassuol.pb.challenge.ecommerce.domain.entities;
import br.com.compassuol.pb.challenge.ecommerce.domain.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents an order in the e-commerce system.
 * This class encapsulates the data related to an order, including the order identifier, the customer identifier,
 * the order items, the creation date, and the status.
 */

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @PrePersist
    public void prePersist() {
        this.date = LocalDateTime.now();
    }
}
