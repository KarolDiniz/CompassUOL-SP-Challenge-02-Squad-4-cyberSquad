package br.com.compassuol.pb.challenge.ecommerce.domain.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceValidateExceptionTest {

    @Test
    void testConstructor() {
        String message = "Invalid price value";
        PriceValidateException exception = new PriceValidateException(message);

        assertEquals(message, exception.getMessage());
    }
}
