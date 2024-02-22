package com.example.member.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SigninDto {

    private String email;
    private String password;
    private Integer sex;
    private Integer age;

    public SigninDto(String email, String password, Integer sex, Integer age) {
        this.email = email;
        this.password = password;
        this.sex = sex;
        this.age = age;
    }
}
