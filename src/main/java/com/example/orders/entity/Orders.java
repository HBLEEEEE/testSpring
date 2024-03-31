package com.example.orders.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long orderNumber;

    @Column(nullable = false)
    private Long quantity;

    public Orders(Long orderNumber, Long quantity){
        this.orderNumber = orderNumber;
        this.quantity = quantity;
    }
}