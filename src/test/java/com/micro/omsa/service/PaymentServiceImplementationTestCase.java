package com.micro.omsa.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.micro.omsa.model.Payment;
import com.micro.omsa.model.Premium;
import com.micro.omsa.model.UserSignup;
import com.micro.omsa.repo.PaymentRepo;

class PaymentServiceImplementationTestCase {

    @Mock
    private PaymentRepo repo;

    @InjectMocks
    private PaymentServiceImplementation service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddPayment() {
        UserSignup user = new UserSignup();
        Premium premium = new Premium();
        Payment payment = new Payment(1, "Gokul", new Date(), "gokul@okaxis", "100", premium, user);
        doNothing().when(repo).savePayment(payment);

        service.addPayment(payment);

        verify(repo).savePayment(payment);
    }

    @Test
    void testGetAllPayments() {
        UserSignup user = new UserSignup(); 
        Premium premium = new Premium();
        Payment payment1 = new Payment(1, "Gokul", new Date(), "gokul@okaxis", "100", premium, user);
        Payment payment2 = new Payment(2, "Anand", new Date(), "anand@okaxis", "200", premium, user);
        List<Payment> payments = Arrays.asList(payment1, payment2);
        when(repo.findAllPayments()).thenReturn(payments);

        List<Payment> result = service.getallPayments();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(payment1));
        assertTrue(result.contains(payment2));
        verify(repo).findAllPayments();
    }

    @Test
    void testUpdatePayment() {
        UserSignup user = new UserSignup(); 
        Premium premium = new Premium();
        Payment payment = new Payment(1, "Gokul", new Date(), "gokul@okaxis", "100", premium, user);
        doNothing().when(repo).updatePayment(payment);

        service.updatePayment(payment);

        verify(repo).updatePayment(payment);
    }

    @Test
    void testDeletePayment() {
        int paymentId = 1;
        doNothing().when(repo).deletePaymentById(paymentId);

        service.deletePayment(paymentId);

        verify(repo).deletePaymentById(paymentId);
    }
}
