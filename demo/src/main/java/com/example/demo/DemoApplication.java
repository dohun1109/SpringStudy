package com.example.demo;

import com.example.demo.used.Greet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
* 스프링 부트 시작 클래스
* */

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args).getBean(DemoApplication.class).execute();
    }

    //주입 하는 곳
    @Autowired
    Greet greet;

    //실행 메서드 execute()
    private void execute(){
        greet.greeting();
    }


}
