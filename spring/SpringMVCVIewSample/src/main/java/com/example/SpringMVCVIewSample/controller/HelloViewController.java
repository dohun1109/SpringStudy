package com.example.SpringMVCVIewSample.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller     //controller 부분 인스턴스 생성 어노테이션 (데이터 입출력 제어)
@RequestMapping("hello")        //controller 의 요청 핸들러 메서드와 URL을 맵핑
//value ->매핑할 url 경로,value 의 처음 / 생략가능, url 여러개 가능, method -> GET 과 POST 등의 HTTP 메서드 지정
public class HelloViewController {

    @GetMapping("view")     //GET 요청용 어노테이션 
    public String helloView() {
        //반환값으로 뷰의 이름을 돌려줌
        return "hello";
    }
}
