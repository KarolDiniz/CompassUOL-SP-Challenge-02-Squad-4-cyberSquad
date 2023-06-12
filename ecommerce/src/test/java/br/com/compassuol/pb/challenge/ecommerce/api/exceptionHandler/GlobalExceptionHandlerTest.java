package br.com.compassuol.pb.challenge.ecommerce.api.exceptionHandler;

import br.com.compassuol.pb.challenge.ecommerce.api.exceptionHandler.GlobalExceptionHandler;
import br.com.compassuol.pb.challenge.ecommerce.domain.exception.ProductNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandlerTest {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Mock
    private WebRequest mockWebRequest;

    @Test
    public void handleConflict_ShouldReturnBadRequestResponse() {

        RuntimeException ex = new IllegalArgumentException();

        ResponseEntity<Object> response = globalExceptionHandler.handleConflict(ex, mockWebRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Ocorreu um erro durante a solicitação.", response.getBody());
    }

    @Test
    public void handleProductNotFoundException_ShouldReturnNotFoundResponse() {
        ProductNotFoundException ex = new ProductNotFoundException("Message-test");

        ResponseEntity<Object> response = globalExceptionHandler.handleProductNotFoundException(ex, mockWebRequest);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Produto não encontrado.", response.getBody());
    }
    @Test
    public void handleDataIntegrityViolationException_ShouldReturnInternalServerErrorResponse() {
        DataIntegrityViolationException ex = new DataIntegrityViolationException("Data integrity violation");

        String response = globalExceptionHandler.handleDataIntegrityViolationException(ex);

        assertEquals("Falha ao cadastrar. O valor inserido já existe.", response);
    }

    @Test
    public void handleNoSuchElementException_ShouldReturnNotFoundResponse() {
        NoSuchElementException ex = new NoSuchElementException();

        String response = globalExceptionHandler.handleNoSuchElementException(ex);

        assertEquals("Recurso não encontrado.", response);
    }
}
