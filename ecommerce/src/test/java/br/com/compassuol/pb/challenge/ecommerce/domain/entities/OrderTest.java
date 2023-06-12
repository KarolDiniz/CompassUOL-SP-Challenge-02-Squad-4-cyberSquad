package br.com.compassuol.pb.challenge.ecommerce.domain.entities;

import br.com.compassuol.pb.challenge.ecommerce.domain.enums.OrderStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testPrePersist() {
        Order order = new Order();
        assertNull(order.getDate());
        order.prePersist();
        assertNotNull(order.getDate());
    }

    @Test
    void testGetId() {
        Order order = new Order();
        order.setId(1L);
        assertEquals(1L, order.getId());
    }

    @Test
    void testGetCustomerId() {
        Order order = new Order();
        order.setCustomerId(1L);
        assertEquals(1L, order.getCustomerId());
    }

    @Test
    void testGetItems() {
        Order order = new Order();
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem());
        order.setItems(items);
        assertEquals(items, order.getItems());
    }

    @Test
    void testGetDate() {
        LocalDateTime now = LocalDateTime.now();
        Order order = new Order();
        order.setDate(now);
        assertEquals(now, order.getDate());
    }

    @Test
    void testGetStatus() {
        OrderStatus status = OrderStatus.CRIADO;
        Order order = new Order();
        order.setStatus(status);
        assertEquals(status, order.getStatus());
    }

    @Test
    void testSetId() {
        Order order = new Order();
        order.setId(1L);
        assertEquals(1L, order.getId());
    }

    @Test
    void testSetCustomerId() {
        Order order = new Order();
        order.setCustomerId(1L);
        assertEquals(1L, order.getCustomerId());
    }

    @Test
    void testSetItems() {
        Order order = new Order();
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem());
        order.setItems(items);
        assertEquals(items, order.getItems());
    }

    @Test
    void testSetDate() {
        LocalDateTime now = LocalDateTime.now();
        Order order = new Order();
        order.setDate(now);
        assertEquals(now, order.getDate());
    }

    @Test
    void testSetStatus() {
        OrderStatus status = OrderStatus.CRIADO;
        Order order = new Order();
        order.setStatus(status);
        assertEquals(status, order.getStatus());
    }

    @Test
    void testEquals() {
        Order order1 = new Order();
        order1.setId(1L);

        Order order2 = new Order();
        order2.setId(1L);

        Order order3 = new Order();
        order3.setId(2L);

        assertEquals(order1, order2);
        assertNotEquals(order1, order3);
    }

    @Test
    void testCanEqualWithSameType() {
        Order order1 = new Order();
        order1.setId(1L);

        Order order2 = new Order();
        order2.setId(1L);

        assertTrue(order1.canEqual(order2));
    }

    @Test
    void testCanEqualWithDifferentType() {
        Order order = new Order();
        assertFalse(order.canEqual(new Object()));
    }

    @Test
    void testHashCode() {
        Order order1 = new Order();
        order1.setId(1L);

        Order order2 = new Order();
        order2.setId(1L);

        Order order3 = new Order();
        order3.setId(2L);

        assertEquals(order1.hashCode(), order2.hashCode());
        assertNotEquals(order1.hashCode(), order3.hashCode());
    }

    @Test
    void testToString() {
        Order order = new Order();
        order.setId(1L);
        order.setCustomerId(1L);
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem());
        order.setItems(items);
        LocalDateTime now = LocalDateTime.now();
        order.setDate(now);
        OrderStatus status = OrderStatus.CRIADO;
        order.setStatus(status);

        String expectedToString = "Order(id=1, customerId=1, items=" + items + ", date=" + now + ", status=" + status + ")";
        assertEquals(expectedToString, order.toString());
    }
}
