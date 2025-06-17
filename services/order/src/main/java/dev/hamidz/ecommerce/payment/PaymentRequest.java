package dev.hamidz.ecommerce.payment;

import dev.hamidz.ecommerce.customer.CustomerResponse;
import dev.hamidz.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
