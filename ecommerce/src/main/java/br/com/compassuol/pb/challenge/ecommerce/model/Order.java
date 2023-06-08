package br.com.compassuol.pb.challenge.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @NotNull
    @Column(name = "date")
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "status")
    private OrderStatus status;
}
