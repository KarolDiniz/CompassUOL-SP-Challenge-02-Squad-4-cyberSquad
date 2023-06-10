package br.com.compassuol.pb.challenge.ecommerce.domain.service;
import br.com.compassuol.pb.challenge.ecommerce.domain.entities.Payment;
import br.com.compassuol.pb.challenge.ecommerce.domain.repository.OrderRepository;
import br.com.compassuol.pb.challenge.ecommerce.domain.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    public Payment createPayment(Payment payment) {
        validateOrderExistence(payment.getOrderId());
        return paymentRepository.save(payment);
    }

    private void validateOrderExistence(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new IllegalArgumentException("Invalid order ID");
        }
    }
}
