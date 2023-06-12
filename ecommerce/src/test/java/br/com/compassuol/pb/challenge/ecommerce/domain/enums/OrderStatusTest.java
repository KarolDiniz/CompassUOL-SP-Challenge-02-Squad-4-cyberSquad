package br.com.compassuol.pb.challenge.ecommerce.domain.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderStatusTest {

    @Test
    void testOrderStatus() {
        assertEquals("CRIADO", OrderStatus.CRIADO.name());
        assertEquals("CREATED", OrderStatus.CREATED.name());
        assertEquals("CONFIRMADO", OrderStatus.CONFIRMADO.name());

        assertNotEquals(OrderStatus.CRIADO, OrderStatus.CREATED);
        assertNotEquals(OrderStatus.CRIADO, OrderStatus.CONFIRMADO);
        assertNotEquals(OrderStatus.CREATED, OrderStatus.CONFIRMADO);

        assertEquals(OrderStatus.CRIADO, OrderStatus.valueOf("CRIADO"));
        assertEquals(OrderStatus.CREATED, OrderStatus.valueOf("CREATED"));
        assertEquals(OrderStatus.CONFIRMADO, OrderStatus.valueOf("CONFIRMADO"));
    }
}
