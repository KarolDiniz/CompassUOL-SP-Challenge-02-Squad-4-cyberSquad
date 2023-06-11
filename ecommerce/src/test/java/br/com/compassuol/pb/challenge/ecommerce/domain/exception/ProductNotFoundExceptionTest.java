package br.com.compassuol.pb.challenge.ecommerce.domain.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductNotFoundExceptionTest {

    @Test
    void testConstructor() {
        String message = "Product not found with id: 123";
        ProductNotFoundException exception = new ProductNotFoundException(message);

        assertEquals(message, exception.getMessage());
    }
}
