package br.com.compassuol.pb.challenge.ecommerce.controller;
import br.com.compassuol.pb.challenge.ecommerce.exception.ProductNotFoundException;
import br.com.compassuol.pb.challenge.ecommerce.model.Product;
import br.com.compassuol.pb.challenge.ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long productId) {
        try {
            Product product = productService.getProductById(productId);
            return ResponseEntity.ok(product);
        } catch (ProductNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}

