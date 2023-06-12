package br.com.compassuol.pb.challenge.ecommerce.domain.service;

import br.com.compassuol.pb.challenge.ecommerce.domain.entities.Order;
import br.com.compassuol.pb.challenge.ecommerce.domain.entities.OrderItem;
import br.com.compassuol.pb.challenge.ecommerce.domain.repository.CustomerRepository;
import br.com.compassuol.pb.challenge.ecommerce.domain.repository.OrderRepository;
import br.com.compassuol.pb.challenge.ecommerce.domain.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ProductRepository productRepository;

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderService(orderRepository, customerRepository, productRepository);
    }

    @Test
    void getAllOrders() {
        List<Order> orders = new ArrayList<>();
        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> allOrders = orderService.getAllOrders();

        assertEquals(orders, allOrders);
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    void getOrderById_ExistingOrder_ReturnsOrder() {
        Long orderId = 1L;
        Order order = new Order();
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        Optional<Order> retrievedOrder = orderService.getOrderById(orderId);

        assertTrue(retrievedOrder.isPresent());
        assertEquals(order, retrievedOrder.get());
        verify(orderRepository, times(1)).findById(orderId);
    }

    @Test
    void getOrderById_NonExistingOrder_ReturnsEmptyOptional() {
        Long orderId = 1L;
        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());

        Optional<Order> retrievedOrder = orderService.getOrderById(orderId);

        assertTrue(retrievedOrder.isEmpty());
        verify(orderRepository, times(1)).findById(orderId);
    }

    @Test
    void createOrder_ValidOrder_ReturnsCreatedOrder() {
        Order order = new Order();
        List<OrderItem> items = new ArrayList<>();
        order.setItems(items);

        when(customerRepository.existsById(order.getCustomerId())).thenReturn(true);
        when(productRepository.existsById(anyLong())).thenReturn(true);
        when(orderRepository.save(order)).thenReturn(order);

        Order createdOrder = orderService.createOrder(order);

        assertNotNull(createdOrder);
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void createOrder_InvalidCustomer_ThrowsIllegalArgumentException() {
        Order order = new Order();
        order.setCustomerId(1L);

        when(customerRepository.existsById(order.getCustomerId())).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> orderService.createOrder(order));
        verify(orderRepository, never()).save(order);
    }

    @Test
    void getOrdersByCustomerId_ExistingCustomer_ReturnsOrders() {
        Long customerId = 1L;
        List<Order> orders = new ArrayList<>();
        when(customerRepository.existsById(customerId)).thenReturn(true);
        when(orderRepository.findByCustomerId(customerId)).thenReturn(orders);

        List<Order> customerOrders = orderService.getOrdersByCustomerId(customerId);

        assertEquals(orders, customerOrders);
        verify(orderRepository, times(1)).findByCustomerId(customerId);
    }

    @Test
    void getOrdersByCustomerId_NonExistingCustomer_ThrowsIllegalArgumentException() {
        Long customerId = 1L;
        when(customerRepository.existsById(customerId)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> orderService.getOrdersByCustomerId(customerId));
        verify(orderRepository, never()).findByCustomerId(customerId);
    }
}
