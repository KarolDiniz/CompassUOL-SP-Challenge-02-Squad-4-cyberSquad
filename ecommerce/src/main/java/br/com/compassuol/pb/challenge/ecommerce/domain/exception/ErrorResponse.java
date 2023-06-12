package br.com.compassuol.pb.challenge.ecommerce.domain.exception;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * The ErrorResponse class represents an error response from the API.
 * It encapsulates information related to the error status, the error message, and the error type.
 */

@Getter
@Setter
public class ErrorResponse {
    private int status;
    private String message;
    private String error;

    public ErrorResponse(int status, String message, String error) {
        this.status = status;
        this.message = message;
        this.error = error;
    }
}
