package com.example.member.service;


import com.example.member.dto.SigninDto;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public String signin(SigninDto signinDto) {
        Optional<Member> findEmail = memberRepository.findByEmail(signinDto.getEmail());
        if(findEmail.isPresent()){
            throw new RuntimeException();
        }else {
            memberRepository.save(new Member(signinDto));
            return "success";
        }
    }
}
