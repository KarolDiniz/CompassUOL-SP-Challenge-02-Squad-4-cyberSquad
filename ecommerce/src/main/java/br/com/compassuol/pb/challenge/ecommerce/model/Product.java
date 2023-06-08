package br.com.compassuol.pb.challenge.ecommerce.model;
import br.com.compassuol.pb.challenge.ecommerce.interfaces.PriceValidate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long productId;

    @NotEmpty(message = "Name is mandatory")
    @Size(min = 3, message = "Name must have at least 3 characters")
    @Column(name = "name")
    private String name;

    @PriceValidate
    @Column(name = "price")
    private BigDecimal price;

    @NotEmpty(message = "Description is mandatory")
    @Size(min = 3, message = "Description must have at least 3 characters")
    @Column(name = "description")
    private String description;
}
