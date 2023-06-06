package br.com.compassuol.pb.challenge.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, message = "Name must have at least 3 characters")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Price is mandatory")
    @Min(value = 0, message = "Price must be a positive value")
    @Column(name = "price")
    private BigDecimal price;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 3, message = "Description must have at least 3 characters")
    @Column(name = "description")
    private String description;
}
