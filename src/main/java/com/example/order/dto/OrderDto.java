package com.example.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

    private Long orderNumber;
    private Long quantity;

    public OrderDto(Long orderNumber, Long quantity) {
        this.orderNumber = orderNumber;
        this.quantity = quantity;
    }
}