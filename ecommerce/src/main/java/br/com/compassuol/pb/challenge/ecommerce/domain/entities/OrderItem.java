package br.com.compassuol.pb.challenge.ecommerce.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents an order item in the e-commerce system.
 * This class encapsulates the data related to an order item, including the identifier, product identifier
 * and the quantity.
 */

@Data
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(nullable = false)
    private int quantity;

}
