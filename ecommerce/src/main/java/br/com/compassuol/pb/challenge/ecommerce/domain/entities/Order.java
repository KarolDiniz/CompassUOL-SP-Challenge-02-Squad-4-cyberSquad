package br.com.compassuol.pb.challenge.ecommerce.domain.entities;
import br.com.compassuol.pb.challenge.ecommerce.domain.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Representa um pedido no sistema de e-commerce.
 * Esta classe encapsula os dados relacionados a um pedido, incluindo o identificador, o identificador do cliente,
 * os itens do pedido, a data de criação, e o status.
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
