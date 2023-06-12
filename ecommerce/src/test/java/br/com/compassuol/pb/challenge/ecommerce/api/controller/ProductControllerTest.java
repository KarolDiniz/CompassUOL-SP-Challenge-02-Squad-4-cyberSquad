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

        ResponseEntity<Product> response = productController.createProduct(product);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(product, response.getBody());
        verify(productService, times(1)).createProduct(product);
    }

    @Test
    void getAllProducts() {
        List<Product> products = new ArrayList<>(); // Create a list of products
        ProductService productService = mock(ProductService.class);
        when(productService.getAllProducts()).thenReturn(products);
        ProductController productController = new ProductController(productService);

        List<Product> result = productController.getAllProducts();

        assertEquals(products, result);
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void getProductById_ProductExists_ReturnsOk() {
        Long productId = 1L;
        Product product = new Product(); // Create a product object
        ProductService productService = mock(ProductService.class);
        when(productService.getProductById(productId)).thenReturn(product);
        ProductController productController = new ProductController(productService);

        ResponseEntity<Product> response = productController.getProductById(productId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
        verify(productService, times(1)).getProductById(productId);
    }

    @Test
    void getProductById_ProductNotFound_ReturnsNotFound() {
        Long productId = 1L;
        ProductService productService = mock(ProductService.class);
        when(productService.getProductById(productId)).thenThrow(ProductNotFoundException.class);
        ProductController productController = new ProductController(productService);

        ResponseEntity<Product> response = productController.getProductById(productId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(productService, times(1)).getProductById(productId);
    }

    @Test
    void updateProduct_ProductExists_ReturnsOk() {
        Long productId = 1L;
        Product updatedProduct = new Product(); // Create an updated product object
        ProductService productService = mock(ProductService.class);
        when(productService.updateProduct(productId, updatedProduct)).thenReturn(updatedProduct);
        ProductController productController = new ProductController(productService);
        ResponseEntity<Product> response = productController.updateProduct(productId, updatedProduct);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedProduct, response.getBody());
        verify(productService, times(1)).updateProduct(productId, updatedProduct);
    }

    @Test
    void updateProduct_ProductNotFound_ReturnsNotFound() {
        Long productId = 1L;
        Product updatedProduct = new Product(); // Create an updated product object
        ProductService productService = mock(ProductService.class);
        when(productService.updateProduct(productId, updatedProduct)).thenThrow(ProductNotFoundException.class);
        ProductController productController = new ProductController(productService);

        ResponseEntity<Product> response = productController.updateProduct(productId, updatedProduct);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(productService, times(1)).updateProduct(productId, updatedProduct);
    }

    @Test
    void deleteProduct_ProductExists_ReturnsNoContent() {
        Long productId = 1L;
        ProductService productService = mock(ProductService.class);
        ProductController productController = new ProductController(productService);

        ResponseEntity<Void> response = productController.deleteProduct(productId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        verify(productService, times(1)).deleteProduct(productId);
    }

    @Test
    void deleteProduct_ProductNotFound_ReturnsNotFound() {
        Long productId = 1L;
        ProductService productService = mock(ProductService.class);
        doThrow(ProductNotFoundException.class).when(productService).deleteProduct(productId);
        ProductController productController = new ProductController(productService);

        ResponseEntity<Void> response = productController.deleteProduct(productId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(productService, times(1)).deleteProduct(productId);
    }
}
