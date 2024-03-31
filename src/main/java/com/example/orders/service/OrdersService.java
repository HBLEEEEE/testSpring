package com.example.orders.service;

import com.example.orders.dto.OrdersDto;
import com.example.orders.entity.Orders;
import com.example.orders.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.Semaphore;

@Service
@RequiredArgsConstructor
@Transactional
public class OrdersService {

    private final OrdersRepository orderRepository;
    private final Semaphore semaphore;


    public String orderQueue(OrdersDto orderDto){
        orderRepository.save(new Orders(orderDto.getOrderNumber(), orderDto.getQuantity()));

        Optional<Orders> findOrder = orderRepository.findByOrderNumber(orderDto.getOrderNumber());

        String reply = "here : " + findOrder.get().getOrderNumber();
        return reply;
    }

    public String orderSema(OrdersDto orderDto){

        try{
            semaphore.acquire();
            orderRepository.save(new Orders(orderDto.getOrderNumber(), orderDto.getQuantity()));
            Optional<Orders> findOrder = orderRepository.findByOrderNumber(orderDto.getOrderNumber());
            String reply = "here : " + findOrder.get().getOrderNumber();

            return reply;

        }catch (Exception e){

            return "신청 실패";
        }finally {
            semaphore.release();
        }
    }

}
