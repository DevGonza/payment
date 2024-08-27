package com.example.payments.application;

import com.example.payments.domain.Payment;
import com.example.payments.domain.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(Payment payment) {
        Payment savedPayment = paymentRepository.save(payment);
        savedPayment.setCardNumber(maskCardNumber(savedPayment.getCardNumber()));
        return savedPayment;
    }

    public List<Payment> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        payments.forEach(payment -> payment.setCardNumber(maskCardNumber(payment.getCardNumber())));
        return payments;
    }

    private String maskCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 8) {
            return cardNumber;
        }
        String firstFour = cardNumber.substring(0, 4);
        String lastFour = cardNumber.substring(cardNumber.length() - 4);
        String maskedPart = "X".repeat(cardNumber.length() - 8);
        return firstFour + maskedPart + lastFour;
    }

}
