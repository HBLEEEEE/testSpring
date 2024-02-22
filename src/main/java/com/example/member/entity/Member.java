package com.example.member.entity;

import com.example.member.dto.SigninDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer sex;

    @Column(nullable = false)
    private Integer age;

    public Member(SigninDto signinDto){
        this.email = signinDto.getEmail();
        this.password = signinDto.getPassword();
        this.sex = signinDto.getSex();
        this.age = signinDto.getAge();
    }
}
