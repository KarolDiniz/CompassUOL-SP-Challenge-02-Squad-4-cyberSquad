package br.com.compassuol.pb.challenge.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpay")
    private Long paymenttId;

    @NotNull(message = "Method Payment is mandatory")
    @Min(value = 0, message = "Price must be a positive value")
    @Column(name = "method")
    private int methodPayment;

    LocalDate datepay = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
    String formattedDate = datepay.format(formatter);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpro")
    private Long idProduct;

    @Column(name = "statuaOrder")
    private Boolean statusOrder;





}
