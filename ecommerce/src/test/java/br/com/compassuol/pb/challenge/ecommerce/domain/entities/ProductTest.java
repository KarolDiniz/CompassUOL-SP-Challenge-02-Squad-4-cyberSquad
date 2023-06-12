package br.com.compassuol.pb.challenge.ecommerce.domain.entities;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testGetProductId() {
        Product product = new Product();
        product.setProductId(1L);
        assertEquals(1L, product.getProductId());
    }

    @Test
    void testGetName() {
        Product product = new Product();
        product.setName("Product 1");
        assertEquals("Product 1", product.getName());
    }

    @Test
    void testGetPrice() {
        BigDecimal price = new BigDecimal("10.00");
        Product product = new Product();
        product.setPrice(price);
        assertEquals(price, product.getPrice());
    }

    @Test
    void testGetDescription() {
        Product product = new Product();
        product.setDescription("Product description");
        assertEquals("Product description", product.getDescription());
    }

    @Test
    void testSetProductId() {
        Product product = new Product();
        product.setProductId(1L);
        assertEquals(1L, product.getProductId());
    }

    @Test
    void testSetName() {
        Product product = new Product();
        product.setName("Product 1");
        assertEquals("Product 1", product.getName());
    }

    @Test
    void testSetPrice() {
        BigDecimal price = new BigDecimal("10.00");
        Product product = new Product();
        product.setPrice(price);
        assertEquals(price, product.getPrice());
    }

    @Test
    void testSetDescription() {
        Product product = new Product();
        product.setDescription("Product description");
        assertEquals("Product description", product.getDescription());
    }

    @Test
    void testEquals() {
        Product product1 = new Product();
        product1.setProductId(1L);

        Product product2 = new Product();
        product2.setProductId(1L);

        Product product3 = new Product();
        product3.setProductId(2L);

        assertEquals(product1, product2);
        assertNotEquals(product1, product3);
    }

    @Test
    void testCanEqualWithSameType() {
        Product product1 = new Product();
        product1.setProductId(1L);

        Product product2 = new Product();
        product2.setProductId(1L);

        assertTrue(product1.canEqual(product2));
    }

    @Test
    void testCanEqualWithDifferentType() {
        Product product = new Product();
        assertFalse(product.canEqual(new Object()));
    }

    @Test
    void testHashCode() {
        Product product1 = new Product();
        product1.setProductId(1L);

        Product product2 = new Product();
        product2.setProductId(1L);

        Product product3 = new Product();
        product3.setProductId(2L);

        assertEquals(product1.hashCode(), product2.hashCode());
        assertNotEquals(product1.hashCode(), product3.hashCode());
    }

    @Test
    void testToString() {
        Product product = new Product();
        product.setProductId(1L);
        product.setName("Product 1");
        BigDecimal price = new BigDecimal("10.00");
        product.setPrice(price);
        product.setDescription("Product description");

        String expectedToString = "Product(productId=1, name=Product 1, price=10.00, description=Product description)";
        assertEquals(expectedToString, product.toString());
    }
}
