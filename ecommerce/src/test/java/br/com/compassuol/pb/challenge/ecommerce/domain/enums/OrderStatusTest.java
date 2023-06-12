package br.com.compassuol.pb.challenge.ecommerce.domain.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderStatusTest {

    @Test
    void testOrderStatus() {
        assertEquals("CRIADO", OrderStatus.CRIADO.name());
        assertEquals("CONFIRMADO", OrderStatus.CONFIRMADO.name());

        assertNotEquals(OrderStatus.CRIADO, OrderStatus.CONFIRMADO);

        assertEquals(OrderStatus.CRIADO, OrderStatus.valueOf("CRIADO"));
        assertEquals(OrderStatus.CONFIRMADO, OrderStatus.valueOf("CONFIRMADO"));
    }
}
