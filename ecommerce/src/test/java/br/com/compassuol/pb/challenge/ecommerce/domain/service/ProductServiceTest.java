package br.com.compassuol.pb.challenge.ecommerce.domain.service;

import br.com.compassuol.pb.challenge.ecommerce.domain.entities.Payment;
import br.com.compassuol.pb.challenge.ecommerce.domain.repository.OrderRepository;
import br.com.compassuol.pb.challenge.ecommerce.domain.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {
    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private OrderRepository orderRepository;

    private PaymentService paymentService;
    @Test
    void createPayment_ValidPayment_ReturnsCreatedPayment() {
        MockitoAnnotations.openMocks(this);
        paymentService = new PaymentService(paymentRepository, orderRepository);

        Payment payment = new Payment();

        when(orderRepository.existsById(payment.getOrderId())).thenReturn(true);
        when(paymentRepository.save(payment)).thenReturn(payment);

        Payment createdPayment = paymentService.createPayment(payment);

        assertEquals(payment, createdPayment);
        verify(orderRepository, times(1)).existsById(payment.getOrderId());
        verify(paymentRepository, times(1)).save(payment);
    }
    @Test
    void createPayment_InvalidOrder_ThrowsIllegalArgumentException() {
        MockitoAnnotations.openMocks(this);
        paymentService = new PaymentService(paymentRepository, orderRepository);

        Payment payment = new Payment();

        when(orderRepository.existsById(payment.getOrderId())).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> paymentService.createPayment(payment));
        verify(orderRepository, times(1)).existsById(payment.getOrderId());
        verify(paymentRepository, never()).save(payment);
    }
}