package br.com.compassuol.pb.challenge.ecommerce.domain.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentMethodTest {

    @Test
    void testPaymentMethods() {
        assertEquals("CREDIT_CARD", PaymentMethod.CREDIT_CARD.name());
        assertEquals("DEBIT_CARD", PaymentMethod.DEBIT_CARD.name());
        assertEquals("TRANSFER", PaymentMethod.TRANSFER.name());
        assertEquals("PIX", PaymentMethod.PIX.name());
        assertEquals("CASH", PaymentMethod.CASH.name());

        assertNotEquals(PaymentMethod.CREDIT_CARD, PaymentMethod.DEBIT_CARD);
        assertNotEquals(PaymentMethod.CREDIT_CARD, PaymentMethod.TRANSFER);
        assertNotEquals(PaymentMethod.CREDIT_CARD, PaymentMethod.PIX);
        assertNotEquals(PaymentMethod.CREDIT_CARD, PaymentMethod.CASH);
        assertNotEquals(PaymentMethod.DEBIT_CARD, PaymentMethod.TRANSFER);
        assertNotEquals(PaymentMethod.DEBIT_CARD, PaymentMethod.PIX);
        assertNotEquals(PaymentMethod.DEBIT_CARD, PaymentMethod.CASH);
        assertNotEquals(PaymentMethod.TRANSFER, PaymentMethod.PIX);
        assertNotEquals(PaymentMethod.TRANSFER, PaymentMethod.CASH);
        assertNotEquals(PaymentMethod.PIX, PaymentMethod.CASH);

        assertEquals(PaymentMethod.CREDIT_CARD, PaymentMethod.valueOf("CREDIT_CARD"));
        assertEquals(PaymentMethod.DEBIT_CARD, PaymentMethod.valueOf("DEBIT_CARD"));
        assertEquals(PaymentMethod.TRANSFER, PaymentMethod.valueOf("TRANSFER"));
        assertEquals(PaymentMethod.PIX, PaymentMethod.valueOf("PIX"));
        assertEquals(PaymentMethod.CASH, PaymentMethod.valueOf("CASH"));
    }
}
