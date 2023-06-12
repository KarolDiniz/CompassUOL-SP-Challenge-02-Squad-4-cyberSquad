package br.com.compassuol.pb.challenge.ecommerce.api.controller;
import br.com.compassuol.pb.challenge.ecommerce.domain.entities.Payment;
import br.com.compassuol.pb.challenge.ecommerce.domain.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller responsible for handling requests related to payments.
 * In it, the emphasis is on the operation of creating (Post) a specific payment.
 */

@RestController
@RequestMapping("/v1/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(@Valid @RequestBody Payment payment) {
        try {
            var createdPayment = paymentService.createPayment(payment);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPayment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

