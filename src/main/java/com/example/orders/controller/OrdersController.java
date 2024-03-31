package com.example.orders.controller;

import com.example.orders.dto.OrdersDto;
import com.example.orders.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService orderService;

    @PostMapping("/orderQueue")
    @ResponseBody
    public String orderQueue(@RequestBody OrdersDto orderDto){
        return orderService.orderQueue(orderDto);
    }

    @PostMapping("/orderSemapore")
    @ResponseBody
    public String orderSemapore(@RequestBody OrdersDto orderDto){
        return orderService.orderSema(orderDto);
    }
}