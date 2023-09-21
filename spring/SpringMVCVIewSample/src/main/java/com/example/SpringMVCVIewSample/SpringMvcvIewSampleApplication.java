package com.example.SpringMVCVIewSample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcvIewSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcvIewSampleApplication.class, args);
    }

    /*
    * GET 으로 URL:hello/view 가 보내짐 ->
    * GET 으로 URL 에 대응하는 요청 핸들러 메서드인 helloView 가 실행됨
    * 반환값( 뷰 이름 ) : hello =>> 반환값 == 뷰이름
    * resource/templates 폴더에서 뷰 이름에 대응하는 뷰를 응답으로 돌려줌  
    * */

}
