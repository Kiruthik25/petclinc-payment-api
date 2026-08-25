package com.petclinic.payment;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PaymentService {

    private final Map<Long, Payment> payments = new ConcurrentHashMap<>();

    private final AtomicLong idGenerator = new AtomicLong(1);

    public Payment createPayment(Long ownerId, Double amount) {

        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException(
                    "Payment amount must be greater than zero"
            );
        }

        Long id = idGenerator.getAndIncrement();

        Payment payment = new Payment(
                id,
                ownerId,
                amount,
                "COMPLETED"
        );

        payments.put(id, payment);

        return payment;
    }

    public Payment getPayment(Long id) {

        Payment payment = payments.get(id);

        if (payment == null) {
            throw new IllegalArgumentException("Payment not found");
        }

        return payment;
    }
}
