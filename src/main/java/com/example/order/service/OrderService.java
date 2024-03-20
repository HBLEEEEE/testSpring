package com.example.order.service;

import com.example.member.dto.SigninDto;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import com.example.order.dto.OrderDto;
import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public String orderQueue(OrderDto orderDto){
        orderRepository.save(new Order(orderDto.getOrderNumber(), orderDto.getQuantity()));

        Optional<Order> findOrder = orderRepository.findByOrderNumber(orderDto.getOrderNumber());

        String reply = "here : " + findOrder.get().getOrderNumber();
        return reply;
    }

    public String orderSema(OrderDto orderDto){
        orderRepository.save(new Order(orderDto.getOrderNumber(), orderDto.getQuantity()));

        Optional<Order> findOrder = orderRepository.findByOrderNumber(orderDto.getOrderNumber());

        String reply = "here : " + findOrder.get().getOrderNumber();
        return reply;
    }

}
