package br.com.compassuol.pb.challenge.ecommerce.domain.exception;
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}