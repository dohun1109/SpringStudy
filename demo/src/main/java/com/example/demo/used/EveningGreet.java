package com.example.demo.used;


import org.springframework.stereotype.Component;

//    Greet 구현하기
//    저녁 인사 하기
@Component
public class EveningGreet implements Greet{

    @Override
    public void greeting() {
        System.out.println("---".repeat(5));
        System.out.println("좋은 저녁입니다.");
        System.out.println("---".repeat(5));
    }
}
