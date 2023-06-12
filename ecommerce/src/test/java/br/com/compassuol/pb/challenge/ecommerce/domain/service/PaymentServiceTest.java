package br.com.compassuol.pb.challenge.ecommerce.domain.service;

import br.com.compassuol.pb.challenge.ecommerce.domain.entities.Payment;
import br.com.compassuol.pb.challenge.ecommerce.domain.repository.OrderRepository;
import br.com.compassuol.pb.challenge.ecommerce.domain.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    private PaymentService paymentService;

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentService = new PaymentService(paymentRepository, orderRepository);
    }

    @Test
    void createPayment_ValidPayment_CallsPaymentRepositorySave() {
        Payment payment = new Payment();
        payment.setOrderId(1L);

        when(orderRepository.existsById(payment.getOrderId())).thenReturn(true);

        paymentService.createPayment(payment);

        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    void createPayment_InvalidOrder_ThrowsIllegalArgumentException() {
        Payment payment = new Payment();
        payment.setOrderId(1L);

        when(orderRepository.existsById(payment.getOrderId())).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> paymentService.createPayment(payment));

        verify(paymentRepository, never()).save(payment);
    }
}
