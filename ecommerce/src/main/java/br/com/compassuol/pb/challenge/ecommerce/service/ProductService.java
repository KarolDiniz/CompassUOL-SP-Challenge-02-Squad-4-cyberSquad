package br.com.compassuol.pb.challenge.ecommerce.service;
import br.com.compassuol.pb.challenge.ecommerce.exception.ProductNotFoundException;
import br.com.compassuol.pb.challenge.ecommerce.model.Product;
import org.springframework.stereotype.Service;
import br.com.compassuol.pb.challenge.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));
    }

}