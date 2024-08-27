package com.example.payments.application;

import com.example.payments.domain.Payment;
import com.example.payments.domain.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PaymentServiceTest {

    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private PaymentRepository paymentRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePayment() {
        Payment payment = new Payment();
        payment.setCardNumber("1234567890123456");
        payment.setAmount(100.0);
        payment.setPaymentDate(LocalDate.now());
        payment.setDescription("Test Payment");

        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        Payment savedPayment = paymentService.createPayment(payment);

        assertEquals(payment.getAmount(), savedPayment.getAmount());
        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    public void testGetAllPayments() {
        Payment payment = new Payment();
        payment.setCardNumber("1234567890123456");
        payment.setAmount(100.0);
        payment.setPaymentDate(LocalDate.now());
        payment.setDescription("Test Payment");

        when(paymentRepository.findAll()).thenReturn(Collections.singletonList(payment));

        List<Payment> payments = paymentService.getAllPayments();

        assertEquals(1, payments.size());
        verify(paymentRepository, times(1)).findAll();
    }

}
