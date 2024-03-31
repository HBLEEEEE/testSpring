package com.example.orders.repository;

import com.example.orders.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    Optional<Orders> findByOrderNumber(Long orderNumber);
}