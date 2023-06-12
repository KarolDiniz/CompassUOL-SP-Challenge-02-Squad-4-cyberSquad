package br.com.compassuol.pb.challenge.ecommerce.domain.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testGetCustomerId() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        assertEquals(1L, customer.getCustomerId());
    }

    @Test
    void testGetName() {
        Customer customer = new Customer();
        customer.setName("Pedro");
        assertEquals("Pedro", customer.getName());
    }

    @Test
    void testGetCpf() {
        Customer customer = new Customer();
        customer.setCpf("12345678901");
        assertEquals("12345678901", customer.getCpf());
    }

    @Test
    void testGetEmail() {
        Customer customer = new Customer();
        customer.setEmail("pedro@example.com");
        assertEquals("pedro@example.com", customer.getEmail());
    }

    @Test
    void testIsActive() {
        Customer customer = new Customer();
        customer.setActive(true);
        assertTrue(customer.isActive());
    }

    @Test
    void testSetCustomerId() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        assertEquals(1L, customer.getCustomerId());
    }

    @Test
    void testSetName() {
        Customer customer = new Customer();
        customer.setName("Pedro");
        assertEquals("Pedro", customer.getName());
    }

    @Test
    void testSetCpf() {
        Customer customer = new Customer();
        customer.setCpf("12345678901");
        assertEquals("12345678901", customer.getCpf());
    }

    @Test
    void testSetEmail() {
        Customer customer = new Customer();
        customer.setEmail("pedro@example.com");
        assertEquals("pedro@example.com", customer.getEmail());
    }

    @Test
    void testSetActive() {
        Customer customer = new Customer();
        customer.setActive(true);
        assertTrue(customer.isActive());
    }

    @Test
    void testEquals() {
        Customer customer1 = new Customer();
        customer1.setCustomerId(1L);

        Customer customer2 = new Customer();
        customer2.setCustomerId(1L);

        Customer customer3 = new Customer();
        customer3.setCustomerId(2L);

        assertEquals(customer1, customer2);
        assertNotEquals(customer1, customer3);
    }

    @Test
    void testCanEqualWithSameType() {
        Customer customer1 = new Customer();
        customer1.setCustomerId(1L);

        Customer customer2 = new Customer();
        customer2.setCustomerId(1L);

        assertTrue(customer1.canEqual(customer2));
    }

    @Test
    void testCanEqualWithDifferentType() {
        Customer customer = new Customer();
        assertFalse(customer.canEqual(new Object()));
    }

    @Test
    void testHashCode() {
        Customer customer1 = new Customer();
        customer1.setCustomerId(1L);

        Customer customer2 = new Customer();
        customer2.setCustomerId(1L);

        Customer customer3 = new Customer();
        customer3.setCustomerId(2L);

        assertEquals(customer1.hashCode(), customer2.hashCode());
        assertNotEquals(customer1.hashCode(), customer3.hashCode());
    }

    @Test
    void testToString() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setName("Pedro");
        customer.setCpf("12345678901");
        customer.setEmail("pedro@example.com");
        customer.setActive(true);

        String expectedToString = "Customer(customerId=1, name=Pedro, cpf=12345678901, email=pedro@example.com, active=true)";
        assertEquals(expectedToString, customer.toString());
    }
}
