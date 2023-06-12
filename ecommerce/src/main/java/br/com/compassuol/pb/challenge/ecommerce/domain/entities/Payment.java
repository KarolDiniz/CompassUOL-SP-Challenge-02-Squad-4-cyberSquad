package br.com.compassuol.pb.challenge.ecommerce.domain.entities;

import br.com.compassuol.pb.challenge.ecommerce.domain.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Representa um pagamento no sistema de e-commerce.
 * Esta classe encapsula os dados relacionados a um pagamento, incluindo o identificador, o identificador do pedido,
 * o método de pagamento, a data do pagamento.
 */

@Data
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orderId", nullable = false)
    @Positive
    private Long orderId;

    @Enumerated(EnumType.STRING)
    @Column(name = "paymentMethod", nullable = false)
    private PaymentMethod paymentMethod;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;

    @PrePersist
    public void prePersist() {
        this.paymentDate = LocalDateTime.now();
    }
}
