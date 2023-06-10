package br.com.compassuol.pb.challenge.ecommerce.api.exceptionHandler;

import br.com.compassuol.pb.challenge.ecommerce.domain.exception.ErrorResponse;
import br.com.compassuol.pb.challenge.ecommerce.domain.exception.PriceValidateException;
import br.com.compassuol.pb.challenge.ecommerce.domain.exception.ProductNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class CustomExceptionHandlerTest {

    @Test
    void handleConflict() {
        CustomExceptionHandler exceptionHandler = new CustomExceptionHandler();
        RuntimeException ex = new RuntimeException("Conflict");
        WebRequest webRequest = mock(WebRequest.class);

        ResponseEntity<Object> response = exceptionHandler.handleConflict(ex, webRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Ocorreu um erro durante a solicitação.", response.getBody());
    }

    @Test
    void handleValidationException() {
        CustomExceptionHandler exceptionHandler = new CustomExceptionHandler();
        ConstraintViolationException ex = new ConstraintViolationException("Validation failed", Set.of());
        WebRequest webRequest = mock(WebRequest.class);

        ResponseEntity<ErrorResponse> response = exceptionHandler.handleValidationException(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Validation error", response.getBody().getMessage());
        assertEquals(0, response.getBody().getErrors().size());
    }

    @Test
    void handleProductNotFoundException() {
        CustomExceptionHandler exceptionHandler = new CustomExceptionHandler();
        ProductNotFoundException ex = new ProductNotFoundException("Product not found");
        WebRequest webRequest = mock(WebRequest.class);

        ResponseEntity<Object> response = exceptionHandler.handleProductNotFoundException(ex, webRequest);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Produto não encontrado.", response.getBody());
    }

    @Test
    void handlePriceValidationException() {
        CustomExceptionHandler exceptionHandler = new CustomExceptionHandler();
        PriceValidateException ex = new PriceValidateException("Invalid price");

        ResponseEntity<String> response = exceptionHandler.handlePriceValidationException(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid price", response.getBody());
    }
}
