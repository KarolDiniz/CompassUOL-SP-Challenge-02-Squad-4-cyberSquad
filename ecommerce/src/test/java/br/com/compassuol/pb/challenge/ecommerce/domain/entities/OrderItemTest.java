package br.com.compassuol.pb.challenge.ecommerce.domain.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    @Test
    void testGetId() {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(1L);
        assertEquals(1L, orderItem.getId());
    }

    @Test
    void testGetProductId() {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(1L);
        assertEquals(1L, orderItem.getProductId());
    }

    @Test
    void testGetQuantity() {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(5);
        assertEquals(5, orderItem.getQuantity());
    }

    @Test
    void testSetId() {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(1L);
        assertEquals(1L, orderItem.getId());
    }

    @Test
    void testSetProductId() {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(1L);
        assertEquals(1L, orderItem.getProductId());
    }

    @Test
    void testSetQuantity() {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(5);
        assertEquals(5, orderItem.getQuantity());
    }

    @Test
    void testEquals() {
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setId(1L);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setId(1L);

        OrderItem orderItem3 = new OrderItem();
        orderItem3.setId(2L);

        assertEquals(orderItem1, orderItem2);
        assertNotEquals(orderItem1, orderItem3);
    }

    @Test
    void testCanEqualWithSameType() {
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setId(1L);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setId(1L);

        assertTrue(orderItem1.canEqual(orderItem2));
    }

    @Test
    void testCanEqualWithDifferentType() {
        OrderItem orderItem = new OrderItem();
        assertFalse(orderItem.canEqual(new Object()));
    }

    @Test
    void testHashCode() {
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setId(1L);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setId(1L);

        OrderItem orderItem3 = new OrderItem();
        orderItem3.setId(2L);

        assertEquals(orderItem1.hashCode(), orderItem2.hashCode());
        assertNotEquals(orderItem1.hashCode(), orderItem3.hashCode());
    }

    @Test
    void testToString() {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(1L);
        orderItem.setProductId(1L);
        orderItem.setQuantity(5);

        String expectedToString = "OrderItem(id=1, productId=1, quantity=5)";
        assertEquals(expectedToString, orderItem.toString());
    }
}
