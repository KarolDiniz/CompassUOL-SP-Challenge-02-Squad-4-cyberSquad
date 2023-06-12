package br.com.compassuol.pb.challenge.ecommerce.domain.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorResponseTest {

    @Test
    void testGetStatus() {
        int status = 500;
        String message = "Internal Server Error";
        String error = "Error";
        ErrorResponse errorResponse = new ErrorResponse(status, message, error);

        assertEquals(status, errorResponse.getStatus());
    }

    @Test
    void testGetMessage() {
        int status = 500;
        String message = "Internal Server Error";
        String error = "Error";
        ErrorResponse errorResponse = new ErrorResponse(status, message, error);

        assertEquals(message, errorResponse.getMessage());
    }

    @Test
    void testGetError() {
        int status = 500;
        String message = "Internal Server Error";
        String error = "Error";
        ErrorResponse errorResponse = new ErrorResponse(status, message, error);

        assertEquals(error, errorResponse.getError());
    }

    @Test
    void testSetStatus() {
        int status = 500;
        String message = "Internal Server Error";
        String error = "Error";
        ErrorResponse errorResponse = new ErrorResponse(status, message, error);

        int newStatus = 400;
        errorResponse.setStatus(newStatus);

        assertEquals(newStatus, errorResponse.getStatus());
    }

    @Test
    void testSetMessage() {
        int status = 500;
        String message = "Internal Server Error";
        String error = "Error";
        ErrorResponse errorResponse = new ErrorResponse(status, message, error);

        String newMessage = "Bad Request";
        errorResponse.setMessage(newMessage);

        assertEquals(newMessage, errorResponse.getMessage());
    }

    @Test
    void testSetError() {
        int status = 500;
        String message = "Internal Server Error";
        String error = "Error";
        ErrorResponse errorResponse = new ErrorResponse(status, message, error);

        String newError = "New Error";
        errorResponse.setError(newError);

        assertEquals(newError, errorResponse.getError());
    }
}
