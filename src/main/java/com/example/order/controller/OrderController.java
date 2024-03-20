package com.example.order.controller;

import com.example.member.dto.SigninDto;
import com.example.member.service.MemberService;
import com.example.order.dto.OrderDto;
import com.example.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orderQueue")
    @ResponseBody
    public String orderQueue(@RequestBody OrderDto orderDto){
        return orderService.orderQueue(orderDto);
    }

    @PostMapping("/orderSemapore")
    @ResponseBody
    public String orderSemapore(@RequestBody OrderDto orderDto){
        return orderService.orderSema(orderDto);
    }
}