package com.petclinic.payment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(
            @RequestParam Long ownerId,
            @RequestParam Double amount
    ) {

        Payment payment =
                paymentService.createPayment(ownerId, amount);

        return ResponseEntity.ok(payment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPayment(
            @PathVariable Long id
    ) {

        Payment payment = paymentService.getPayment(id);

        return ResponseEntity.ok(payment);
    }
}
