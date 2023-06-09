package br.com.compassuol.pb.challenge.ecommerce.service;

import br.com.compassuol.pb.challenge.ecommerce.model.Order;
import br.com.compassuol.pb.challenge.ecommerce.model.OrderItem;
import br.com.compassuol.pb.challenge.ecommerce.model.OrderStatus;
import br.com.compassuol.pb.challenge.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        validateOrder(order);
        order.setStatus(OrderStatus.CRIADO);
        return orderRepository.save(order);
    }

    private void validateOrder(Order order) {
        validateCustomerExistence(order.getCustomerId());
        validateProductExistence(order.getItems());
    }

    private void validateCustomerExistence(Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new IllegalArgumentException("Invalid customer ID");
        }
    }

    private void validateProductExistence(List<OrderItem> items) {
        for (OrderItem item : items) {
            if (!productRepository.existsById(item.getProductId())) {
                throw new IllegalArgumentException("Invalid product ID");
            }
        }
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {
        validateCustomerExistence(customerId);
        return orderRepository.findByCustomerId(customerId);
    }
}
