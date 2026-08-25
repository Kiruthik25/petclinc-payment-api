package com.petclinic.payment;

public record Payment(
        Long id,
        Long ownerId,
        Double amount,
        String status
) {
}
