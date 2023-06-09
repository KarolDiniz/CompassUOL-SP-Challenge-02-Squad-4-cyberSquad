package br.com.compassuol.pb.challenge.ecommerce.model;

import br.com.compassuol.pb.challenge.ecommerce.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void getCustomerId() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);

        assertEquals(1L, customer.getCustomerId());
    }

    @Test
    void getName() {
        Customer customer = new Customer();
        customer.setName("Pedro");

        assertEquals("Pedro", customer.getName());
    }

    @Test
    void getCpf() {
        Customer customer = new Customer();
        customer.setCpf("12345678900");

        assertEquals("12345678900", customer.getCpf());
    }

    @Test
    void getEmail() {
        Customer customer = new Customer();
        customer.setEmail("pedro@gmail.com");

        assertEquals("pedro@gmail.com", customer.getEmail());
    }

    @Test
    void isActive() {
        Customer customer = new Customer();
        customer.setActive(true);

        assertTrue(customer.isActive());
    }

    @Test
    void setCustomerId() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);

        assertEquals(1L, customer.getCustomerId());
    }

    @Test
    void setName() {
        Customer customer = new Customer();
        customer.setName("Pedro");

        assertEquals("Pedro", customer.getName());
    }

    @Test
    void setCpf() {
        Customer customer = new Customer();
        customer.setCpf("12345678900");

        assertEquals("12345678900", customer.getCpf());
    }

    @Test
    void setEmail() {
        Customer customer = new Customer();
        customer.setEmail("pedro@gmail.com");

        assertEquals("pedro@gmail.com", customer.getEmail());
    }

    @Test
    void setActive() {
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
}
