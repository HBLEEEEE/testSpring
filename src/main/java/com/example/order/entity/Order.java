package com.example.order.entity;

import com.example.member.dto.SigninDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long orderNumber;

    @Column(nullable = false)
    private Long quantity;

    public Order(Long orderNumber, Long quantity){
        this.orderNumber = orderNumber;
        this.quantity = quantity;
    }
}