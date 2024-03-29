package br.com.compassuol.pb.challenge.ecommerce.api.controller;

import br.com.compassuol.pb.challenge.ecommerce.domain.entities.Order;
import br.com.compassuol.pb.challenge.ecommerce.domain.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderControllerTest {
    @Mock
    private OrderService orderService;

    private OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderController = new OrderController(orderService);
    }

    @Test
    void getAllOrders_ReturnsAllOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order());
        orders.add(new Order());

        when(orderService.getAllOrders()).thenReturn(orders);

        ResponseEntity<List<Order>> response = orderController.getAllOrders();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orders, response.getBody());
        verify(orderService, times(1)).getAllOrders();
    }

    @Test
    void getOrderById_ExistingOrderId_ReturnsOrder() {
        // Arrange
        Long orderId = 1L;
        Order order = new Order();
        order.setId(orderId);

        when(orderService.getOrderById(orderId)).thenReturn(Optional.of(order));

        ResponseEntity<Order> response = orderController.getOrderById(orderId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(order, response.getBody());
        verify(orderService, times(1)).getOrderById(orderId);
    }

    @Test
    void getOrderById_NonExistingOrderId_ReturnsNotFound() {
        // Arrange
        Long orderId = 1L;

        when(orderService.getOrderById(orderId)).thenReturn(Optional.empty());

        ResponseEntity<Order> response = orderController.getOrderById(orderId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(orderService, times(1)).getOrderById(orderId);
    }

    @Test
    void createOrder_ValidOrder_ReturnsCreated() {
        Order order = new Order();

        when(orderService.createOrder(order)).thenReturn(order);

        ResponseEntity<Order> response = orderController.createOrder(order);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(order, response.getBody());
        verify(orderService, times(1)).createOrder(order);
    }

    @Test
    void createOrder_InvalidOrder_ReturnsBadRequest() {
        Order order = new Order();

        doThrow(IllegalArgumentException.class).when(orderService).createOrder(order);

        ResponseEntity<Order> response = orderController.createOrder(order);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
        verify(orderService, times(1)).createOrder(order);
    }

    @Test
    void getOrdersByCustomerId_ValidCustomerId_ReturnsOrders() {
        Long customerId = 1L;
        List<Order> orders = new ArrayList<>();
        orders.add(new Order());
        orders.add(new Order());

        when(orderService.getOrdersByCustomerId(customerId)).thenReturn(orders);

        ResponseEntity<List<Order>> response = orderController.getOrdersByCustomerId(customerId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orders, response.getBody());
        verify(orderService, times(1)).getOrdersByCustomerId(customerId);
    }

    @Test
    void getOrdersByCustomerId_InvalidCustomerId_ReturnsBadRequest() {
        Long customerId = 1L;

        doThrow(IllegalArgumentException.class).when(orderService).getOrdersByCustomerId(customerId);

        ResponseEntity<List<Order>> response = orderController.getOrdersByCustomerId(customerId);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
        verify(orderService, times(1)).getOrdersByCustomerId(customerId);
    }
}
