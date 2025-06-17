package dev.hamidz.ecommerce.kafka;

import dev.hamidz.ecommerce.customer.CustomerResponse;
import dev.hamidz.ecommerce.order.PaymentMethod;
import dev.hamidz.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
