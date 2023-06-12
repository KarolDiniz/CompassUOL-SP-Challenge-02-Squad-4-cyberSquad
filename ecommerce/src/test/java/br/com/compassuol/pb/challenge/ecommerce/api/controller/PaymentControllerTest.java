package br.com.compassuol.pb.challenge.ecommerce.api.controller;

import br.com.compassuol.pb.challenge.ecommerce.domain.entities.Payment;
import br.com.compassuol.pb.challenge.ecommerce.domain.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentControllerTest {

    @Mock
    private PaymentService paymentService;

    private PaymentController paymentController;

    @Test
    void createPayment_ValidPayment_ReturnsCreatedPayment() {
        MockitoAnnotations.openMocks(this);
        paymentController = new PaymentController(paymentService);

        Payment payment = new Payment();
        Payment createdPayment = new Payment();

        when(paymentService.createPayment(payment)).thenReturn(createdPayment);

        ResponseEntity<Payment> response = paymentController.createPayment(payment);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdPayment, response.getBody());
        verify(paymentService, times(1)).createPayment(payment);
    }

    @Test
    void createPayment_InvalidPayment_ReturnsBadRequest() {
        MockitoAnnotations.openMocks(this);
        paymentController = new PaymentController(paymentService);

        Payment payment = new Payment();

        when(paymentService.createPayment(payment)).thenThrow(new IllegalArgumentException());

        ResponseEntity<Payment> response = paymentController.createPayment(payment);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
        verify(paymentService, times(1)).createPayment(payment);
    }
}
