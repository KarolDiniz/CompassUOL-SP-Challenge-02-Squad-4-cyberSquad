package br.com.compassuol.pb.challenge.ecommerce.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Representa um item de um pedido no sistema de e-commerce.
 * Esta classe encapsula os dados relacionados a um item de pedido, incluindo o identificador, o identificador do produto
 * e a quantidade.
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
