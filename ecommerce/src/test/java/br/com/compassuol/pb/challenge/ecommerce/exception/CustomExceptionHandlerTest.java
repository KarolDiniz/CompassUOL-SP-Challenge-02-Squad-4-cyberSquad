import br.com.compassuol.pb.challenge.ecommerce.exception.CustomExceptionHandler;
import br.com.compassuol.pb.challenge.ecommerce.exception.PriceValidateException;
import br.com.compassuol.pb.challenge.ecommerce.exception.ProductNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomExceptionHandlerTest {

    @Test
    void handleConflict() {
        CustomExceptionHandler handler = new CustomExceptionHandler();

        RuntimeException exception = new RuntimeException("Runtime exception");
        WebRequest webRequest = null;

        ResponseEntity<Object> response = handler.handleConflict(exception, webRequest);

        assertEquals("Ocorreu um erro durante a solicitação.", response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void handleProductNotFoundException() {
        CustomExceptionHandler handler = new CustomExceptionHandler();

        ProductNotFoundException exception = new ProductNotFoundException("Product not found");
        WebRequest webRequest = null;

        ResponseEntity<Object> response = handler.handleProductNotFoundException(exception, webRequest);

        assertEquals("Produto não encontrado.", response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void handlePriceValidationException() {
        CustomExceptionHandler handler = new CustomExceptionHandler();

        PriceValidateException exception = new PriceValidateException("Invalid price");

        ResponseEntity<String> response = handler.handlePriceValidationException(exception);

        assertEquals("Invalid price", response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
