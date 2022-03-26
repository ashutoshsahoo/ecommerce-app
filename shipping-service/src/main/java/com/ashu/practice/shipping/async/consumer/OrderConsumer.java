package com.ashu.practice.shipping.async.consumer;

import com.ashu.practice.common.constants.OrderStatus;
import com.ashu.practice.shipping.async.producer.OrderProducer;
import com.ashu.practice.shipping.domain.Order;
import com.ashu.practice.shipping.reactive.service.ShippingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class OrderConsumer {

    @Autowired
    ShippingService shippingService;

    @Autowired
    OrderProducer orderProducer;

    @KafkaListener(topics = "orders", groupId = "shipping")
    public void consume(Order order) throws IOException {
        log.info("Order received to process: {}", order);
        if (OrderStatus.PREPARE_SHIPPING.equals(order.getOrderStatus())) {
            shippingService.handleOrder(order)
                    .doOnSuccess(o -> {
                        log.info("Order processed successfully.");
                        orderProducer.sendMessage(order.setOrderStatus(OrderStatus.SHIPPING_SUCCESS)
                                .setShippingDate(o.getShippingDate()));
                    })
                    .doOnError(e -> {
                        if (log.isErrorEnabled())
                            log.error("Order failed to process: " + e);
                        orderProducer.sendMessage(order.setOrderStatus(OrderStatus.SHIPPING_FAILURE)
                                .setResponseMessage(e.getMessage()));
                    })
                    .subscribe();
        }
    }
}