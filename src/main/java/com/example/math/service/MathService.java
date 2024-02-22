package com.example.math.service;

import com.example.member.dto.SigninDto;
import com.example.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MathService {
    public int mutiple(int number){
        int ans = number * 2;
        return ans;
    }
}