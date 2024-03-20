package com.example.intertest;

public class Dog implements Animal{

    @Override
    public void bark() {
        System.out.println("멍멍");
    }

    @Override
    public String eat() {
        return "와구와구";
    }

    @Override
    public void move() {
        System.out.println("터벅터벅");
    }
}
