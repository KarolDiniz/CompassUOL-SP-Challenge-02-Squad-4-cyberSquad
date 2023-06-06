package br.com.compassuol.pb.challenge.ecommerce.service;
import org.springframework.stereotype.Service;
import br.com.compassuol.pb.challenge.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}