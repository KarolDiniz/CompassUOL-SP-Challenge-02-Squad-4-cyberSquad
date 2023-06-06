package br.com.compassuol.pb.challenge.ecommerce.exception;
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}