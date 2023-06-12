package br.com.compassuol.pb.challenge.ecommerce.domain.interfaces;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to validate the price of a product.
 * The price must be mandatory, positive, and have at most two decimal places.
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@NotNull(message = "Price is mandatory")
@Min(value = 0, message = "Price must be a positive value")
@Digits(integer = 3, fraction = 2, message = "Only up to 2 decimal places are allowed.")
public @interface PriceValidate {
    String message() default "Invalid price";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

