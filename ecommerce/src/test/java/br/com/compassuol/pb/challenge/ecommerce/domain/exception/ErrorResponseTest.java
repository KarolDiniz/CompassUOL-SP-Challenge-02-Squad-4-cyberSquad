package br.com.compassuol.pb.challenge.ecommerce.domain.exception;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseTest {

    @Test
    void testGetStatus() {
        int status = 500;
        String message = "Internal Server Error";
        List<String> errors = Arrays.asList("Error 1", "Error 2");
        ErrorResponse errorResponse = new ErrorResponse(status, message, errors);

        assertEquals(status, errorResponse.getStatus());
    }

    @Test
    void testGetMessage() {
        int status = 500;
        String message = "Internal Server Error";
        List<String> errors = Arrays.asList("Error 1", "Error 2");
        ErrorResponse errorResponse = new ErrorResponse(status, message, errors);

        assertEquals(message, errorResponse.getMessage());
    }

    @Test
    void testGetErrors() {
        int status = 500;
        String message = "Internal Server Error";
        List<String> errors = Arrays.asList("Error 1", "Error 2");
        ErrorResponse errorResponse = new ErrorResponse(status, message, errors);

        assertEquals(errors, errorResponse.getErrors());
    }

    @Test
    void testSetStatus() {
        int status = 500;
        String message = "Internal Server Error";
        List<String> errors = Arrays.asList("Error 1", "Error 2");
        ErrorResponse errorResponse = new ErrorResponse(status, message, errors);

        int newStatus = 400;
        errorResponse.setStatus(newStatus);

        assertEquals(newStatus, errorResponse.getStatus());
    }

    @Test
    void testSetMessage() {
        int status = 500;
        String message = "Internal Server Error";
        List<String> errors = Arrays.asList("Error 1", "Error 2");
        ErrorResponse errorResponse = new ErrorResponse(status, message, errors);

        String newMessage = "Bad Request";
        errorResponse.setMessage(newMessage);

        assertEquals(newMessage, errorResponse.getMessage());
    }

    @Test
    void testSetErrors() {
        int status = 500;
        String message = "Internal Server Error";
        List<String> errors = Arrays.asList("Error 1", "Error 2");
        ErrorResponse errorResponse = new ErrorResponse(status, message, errors);

        List<String> newErrors = Arrays.asList("Error 3", "Error 4");
        errorResponse.setErrors(newErrors);

        assertEquals(newErrors, errorResponse.getErrors());
    }
}
