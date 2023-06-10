package br.com.compassuol.pb.challenge.ecommerce.api.controller;

import br.com.compassuol.pb.challenge.ecommerce.domain.entities.Product;
import br.com.compassuol.pb.challenge.ecommerce.domain.exception.ProductNotFoundException;
import br.com.compassuol.pb.challenge.ecommerce.domain.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Test
    void createProduct() {
        // Arrange
        Product product = new Product(); // Create a product object
        ProductService productService = mock(ProductService.class);
        when(productService.createProduct(product)).thenReturn(product);
        ProductController productController = new ProductController(productService);

        // Act
        ResponseEntity<Product> response = productController.createProduct(product);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(product, response.getBody());
        verify(productService, times(1)).createProduct(product);
    }

    @Test
    void getAllProducts() {
        // Arrange
        List<Product> products = new ArrayList<>(); // Create a list of products
        ProductService productService = mock(ProductService.class);
        when(productService.getAllProducts()).thenReturn(products);
        ProductController productController = new ProductController(productService);

        // Act
        List<Product> result = productController.getAllProducts();

        // Assert
        assertEquals(products, result);
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void getProductById_ProductExists_ReturnsOk() {
        // Arrange
        Long productId = 1L;
        Product product = new Product(); // Create a product object
        ProductService productService = mock(ProductService.class);
        when(productService.getProductById(productId)).thenReturn(product);
        ProductController productController = new ProductController(productService);

        // Act
        ResponseEntity<Product> response = productController.getProductById(productId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
        verify(productService, times(1)).getProductById(productId);
    }

    @Test
    void getProductById_ProductNotFound_ReturnsNotFound() {
        // Arrange
        Long productId = 1L;
        ProductService productService = mock(ProductService.class);
        when(productService.getProductById(productId)).thenThrow(ProductNotFoundException.class);
        ProductController productController = new ProductController(productService);

        // Act
        ResponseEntity<Product> response = productController.getProductById(productId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(productService, times(1)).getProductById(productId);
    }

    @Test
    void updateProduct_ProductExists_ReturnsOk() {
        // Arrange
        Long productId = 1L;
        Product updatedProduct = new Product(); // Create an updated product object
        ProductService productService = mock(ProductService.class);
        when(productService.updateProduct(productId, updatedProduct)).thenReturn(updatedProduct);
        ProductController productController = new ProductController(productService);

        // Act
        ResponseEntity<Product> response = productController.updateProduct(productId, updatedProduct);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedProduct, response.getBody());
        verify(productService, times(1)).updateProduct(productId, updatedProduct);
    }

    @Test
    void updateProduct_ProductNotFound_ReturnsNotFound() {
        // Arrange
        Long productId = 1L;
        Product updatedProduct = new Product(); // Create an updated product object
        ProductService productService = mock(ProductService.class);
        when(productService.updateProduct(productId, updatedProduct)).thenThrow(ProductNotFoundException.class);
        ProductController productController = new ProductController(productService);

        // Act
        ResponseEntity<Product> response = productController.updateProduct(productId, updatedProduct);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(productService, times(1)).updateProduct(productId, updatedProduct);
    }

    @Test
    void deleteProduct_ProductExists_ReturnsNoContent() {
        // Arrange
        Long productId = 1L;
        ProductService productService = mock(ProductService.class);
        ProductController productController = new ProductController(productService);

        // Act
        ResponseEntity<Void> response = productController.deleteProduct(productId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        verify(productService, times(1)).deleteProduct(productId);
    }

    @Test
    void deleteProduct_ProductNotFound_ReturnsNotFound() {
        // Arrange
        Long productId = 1L;
        ProductService productService = mock(ProductService.class);
        doThrow(ProductNotFoundException.class).when(productService).deleteProduct(productId);
        ProductController productController = new ProductController(productService);

        // Act
        ResponseEntity<Void> response = productController.deleteProduct(productId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(productService, times(1)).deleteProduct(productId);
    }
}
