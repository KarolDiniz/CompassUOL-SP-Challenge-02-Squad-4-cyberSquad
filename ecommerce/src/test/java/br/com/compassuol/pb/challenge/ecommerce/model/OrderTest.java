import br.com.compassuol.pb.challenge.ecommerce.model.Customer;
import br.com.compassuol.pb.challenge.ecommerce.model.Order;
import br.com.compassuol.pb.challenge.ecommerce.model.OrderStatus;
import br.com.compassuol.pb.challenge.ecommerce.model.Product;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getOrderId() {
        Order order = new Order();
        order.setOrderId(1L);

        assertEquals(1L, order.getOrderId());
    }

    @Test
    void getCustomer() {
        Order order = new Order();
        Customer customer = new Customer();
        order.setCustomer(customer);

        assertEquals(customer, order.getCustomer());
    }

    @Test
    void getProducts() {
        Order order = new Order();
        Map<Product, Integer> products = new HashMap<>();
        order.setProducts(products);

        assertEquals(products, order.getProducts());
    }

    @Test
    void getDate() {
        Order order = new Order();
        LocalDate date = LocalDate.now();
        order.setDate(date);

        assertEquals(date, order.getDate());
    }

    @Test
    void getStatus() {
        Order order = new Order();
        order.setStatus(OrderStatus.CREATED);

        assertEquals(OrderStatus.CREATED, order.getStatus());
    }

    @Test
    void setOrderId() {
        Order order = new Order();
        order.setOrderId(1L);

        assertEquals(1L, order.getOrderId());
    }

    @Test
    void setCustomer() {
        Order order = new Order();
        Customer customer = new Customer();
        order.setCustomer(customer);

        assertEquals(customer, order.getCustomer());
    }

    @Test
    void setProducts() {
        Order order = new Order();
        Map<Product, Integer> products = new HashMap<>();
        order.setProducts(products);

        assertEquals(products, order.getProducts());
    }

    @Test
    void setDate() {
        Order order = new Order();
        LocalDate date = LocalDate.now();
        order.setDate(date);

        assertEquals(date, order.getDate());
    }

    @Test
    void setStatus() {
        Order order = new Order();
        order.setStatus(OrderStatus.CREATED);

        assertEquals(OrderStatus.CREATED, order.getStatus());
    }
}
