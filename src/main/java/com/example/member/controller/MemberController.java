package com.example.member.controller;


import com.example.member.dto.SigninDto;
import com.example.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signin")
    @ResponseBody
    public String signin(@RequestBody SigninDto signinDto){
        return memberService.signin(signinDto);
    }
}
