package com.petclinic.payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    private final PaymentService paymentService =
            new PaymentService();

    @Test
    void shouldCreatePayment() {

        Payment payment =
                paymentService.createPayment(1L, 100.0);

        assertNotNull(payment);

        assertEquals(1L, payment.ownerId());

        assertEquals(100.0, payment.amount());

        assertEquals("COMPLETED", payment.status());
    }

    @Test
    void shouldRejectInvalidPayment() {

        assertThrows(
                IllegalArgumentException.class,
                () -> paymentService.createPayment(1L, -10.0)
        );
    }
}
