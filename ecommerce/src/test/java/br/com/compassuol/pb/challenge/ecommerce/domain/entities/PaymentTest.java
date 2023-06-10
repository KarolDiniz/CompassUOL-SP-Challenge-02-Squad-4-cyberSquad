package br.com.compassuol.pb.challenge.ecommerce.domain.entities;

import br.com.compassuol.pb.challenge.ecommerce.domain.enums.PaymentMethod;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void testPrePersist() {
        Payment payment = new Payment();
        payment.prePersist();
        LocalDateTime paymentDate = payment.getPaymentDate();
        assertNotNull(paymentDate);
        assertTrue(paymentDate.isBefore(LocalDateTime.now().plusSeconds(1)));
    }

    @Test
    void testGetId() {
        Payment payment = new Payment();
        payment.setId(1L);
        assertEquals(1L, payment.getId());
    }

    @Test
    void testGetOrderId() {
        Payment payment = new Payment();
        payment.setOrderId(1L);
        assertEquals(1L, payment.getOrderId());
    }

    @Test
    void testGetPaymentMethod() {
        Payment payment = new Payment();
        payment.setPaymentMethod(PaymentMethod.CREDIT_CARD);
        assertEquals(PaymentMethod.CREDIT_CARD, payment.getPaymentMethod());
    }

    @Test
    void testGetPaymentDate() {
        LocalDateTime paymentDate = LocalDateTime.now();
        Payment payment = new Payment();
        payment.setPaymentDate(paymentDate);
        assertEquals(paymentDate, payment.getPaymentDate());
    }

    @Test
    void testSetId() {
        Payment payment = new Payment();
        payment.setId(1L);
        assertEquals(1L, payment.getId());
    }

    @Test
    void testSetOrderId() {
        Payment payment = new Payment();
        payment.setOrderId(1L);
        assertEquals(1L, payment.getOrderId());
    }

    @Test
    void testSetPaymentMethod() {
        Payment payment = new Payment();
        payment.setPaymentMethod(PaymentMethod.CREDIT_CARD);
        assertEquals(PaymentMethod.CREDIT_CARD, payment.getPaymentMethod());
    }

    @Test
    void testSetPaymentDate() {
        LocalDateTime paymentDate = LocalDateTime.now();
        Payment payment = new Payment();
        payment.setPaymentDate(paymentDate);
        assertEquals(paymentDate, payment.getPaymentDate());
    }

    @Test
    void testEquals() {
        Payment payment1 = new Payment();
        payment1.setId(1L);

        Payment payment2 = new Payment();
        payment2.setId(1L);

        Payment payment3 = new Payment();
        payment3.setId(2L);

        assertEquals(payment1, payment2);
        assertNotEquals(payment1, payment3);
    }

    @Test
    void testCanEqualWithSameType() {
        Payment payment1 = new Payment();
        payment1.setId(1L);

        Payment payment2 = new Payment();
        payment2.setId(1L);

        assertTrue(payment1.canEqual(payment2));
    }

    @Test
    void testCanEqualWithDifferentType() {
        Payment payment = new Payment();
        assertFalse(payment.canEqual(new Object()));
    }

    @Test
    void testHashCode() {
        Payment payment1 = new Payment();
        payment1.setId(1L);

        Payment payment2 = new Payment();
        payment2.setId(1L);

        Payment payment3 = new Payment();
        payment3.setId(2L);

        assertEquals(payment1.hashCode(), payment2.hashCode());
        assertNotEquals(payment1.hashCode(), payment3.hashCode());
    }

    @Test
    void testToString() {
        Payment payment = new Payment();
        payment.setId(1L);
        payment.setOrderId(1L);
        payment.setPaymentMethod(PaymentMethod.CREDIT_CARD);
        LocalDateTime paymentDate = LocalDateTime.now();
        payment.setPaymentDate(paymentDate);

        String expectedToString = "Payment(id=1, orderId=1, paymentMethod=CREDIT_CARD, paymentDate=" + paymentDate.toString() + ")";
        assertEquals(expectedToString, payment.toString());
    }
}
