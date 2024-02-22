package com.example.greet.controller;


import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required = false, defaultValue = "Worldddddd") String name, Model model){
        model.addAttribute("name", name);
        return "greeting";

    }

//    @GetMapping("/toPass/{number}")
//    public String toPass(@RequestParam(name="number", required = false, defaultValue = "111111") String number, Model model){
//        model.addAttribute("number", number);
//        String s = "toPass" + number;
//        return s;
//    }

    @GetMapping("/toPass/{number}")
    public String toPass(@PathVariable String number, Model model){
        model.addAttribute("number", number);

        String s = "toPass" + number;
        System.out.println("s = " + s);
        return s;
    }
}
