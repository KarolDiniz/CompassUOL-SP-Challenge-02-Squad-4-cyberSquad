package br.com.compassuol.pb.challenge.ecommerce.service;

import br.com.compassuol.pb.challenge.ecommerce.model.Customer;
import br.com.compassuol.pb.challenge.ecommerce.model.Order;
import br.com.compassuol.pb.challenge.ecommerce.model.OrderStatus;
import br.com.compassuol.pb.challenge.ecommerce.model.Product;
import br.com.compassuol.pb.challenge.ecommerce.repository.CustomerRepository;
import br.com.compassuol.pb.challenge.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductService productService;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productService = productService;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Long customerId, Map<Long, Integer> productQuantities) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        Order order = new Order();
        order.setCustomer(customer);
        order.setProducts(getProductsMap(productQuantities));
        order.setDate(LocalDate.now());
        order.setStatus(OrderStatus.CREATED);

        return orderRepository.save(order);
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerCustomerId(customerId);
    }

    public Order updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = getOrderById(orderId);
        order.setStatus(status);
        return orderRepository.save(order);
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new NoSuchElementException("Order not found"));
    }

    private Map<Product, Integer> getProductsMap(Map<Long, Integer> productQuantities) {
        Map<Product, Integer> products = new HashMap<>();

        for (Map.Entry<Long, Integer> entry : productQuantities.entrySet()) {
            Long productId = entry.getKey();
            Integer quantity = entry.getValue();
            Product product = productService.getProductById(productId);
            products.put(product, quantity);
        }

        return products;
    }
}
