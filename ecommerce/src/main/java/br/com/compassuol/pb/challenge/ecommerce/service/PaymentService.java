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

            return paymentRepository.save(payment);
        }



}


