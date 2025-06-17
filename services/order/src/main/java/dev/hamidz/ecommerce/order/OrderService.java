package dev.hamidz.ecommerce.order;

import dev.hamidz.ecommerce.customer.CustomerClient;
import dev.hamidz.ecommerce.exception.BusinessException;
import dev.hamidz.ecommerce.orderline.OrderLineRequest;
import dev.hamidz.ecommerce.orderline.OrderLineService;
import dev.hamidz.ecommerce.product.ProductClient;
import dev.hamidz.ecommerce.product.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;

    public Integer createOrder(OrderRequest request) {
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No Customer exists with the provided ID"));

        this.productClient.purchaseProducts(request.products());

        var order = this.repository.save(mapper.toOrder(request));

        for (PurchaseRequest purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        // todo : start payment process

        // send the order confirmation --> notification-ms (kafka)

        return null;
    }
}
