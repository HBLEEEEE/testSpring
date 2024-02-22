package com.example.math.controller;

import com.example.math.service.MathService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@ResponseBody
public class MathController {

    private final MathService mathService;

    @GetMapping("/math/multiple/{number}")
    public int multiple(@PathVariable int number){

        return mathService.mutiple(number);
    }
}