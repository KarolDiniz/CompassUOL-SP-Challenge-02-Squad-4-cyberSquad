package br.com.compassuol.pb.challenge.ecommerce.domain.service;
import br.com.compassuol.pb.challenge.ecommerce.domain.exception.ProductNotFoundException;
import br.com.compassuol.pb.challenge.ecommerce.domain.entities.Product;
import br.com.compassuol.pb.challenge.ecommerce.domain.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));
    }

    public Product updateProduct(Long productId, Product product) {
        Product existingProduct = getProductById(productId);
        BeanUtils.copyProperties(product, existingProduct, "productId");
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long productId) {
        Product existingProduct = getProductById(productId);
        productRepository.delete(existingProduct);
    }
}