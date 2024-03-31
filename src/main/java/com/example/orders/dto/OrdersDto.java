package com.example.orders.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersDto {

    private Long orderNumber;
    private Long quantity;

    public OrdersDto(Long orderNumber, Long quantity) {
        this.orderNumber = orderNumber;
        this.quantity = quantity;
    }
}