package br.com.compassuol.pb.challenge.ecommerce.service;

import br.com.compassuol.pb.challenge.ecommerce.model.Payment;
import br.com.compassuol.pb.challenge.ecommerce.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {


        private final PaymentRepository paymentRepository;

        public PaymentService(PaymentRepository paymentRepository) {
            this.paymentRepository = paymentRepository;
        }

        public Payment createPayment(Payment payment) {
            // Implemente a lógica de criação do pagamento
            // Você pode adicionar validações, atribuir valores adicionais, salvar no banco de dados, etc.
            return paymentRepository.save(payment);
        }

        // Outros métodos do serviço, se necessário

}


