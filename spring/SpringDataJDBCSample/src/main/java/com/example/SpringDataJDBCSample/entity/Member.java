package com.example.SpringDataJDBCSample.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.data.annotation.Id;

/*
* Member 테이블 entity
* */
@Data   //-> getter/setter 사용가능 , hashCode(), equals(),toString()
@NoArgsConstructor  //-> 기본 생성자 생성
@AllArgsConstructor //-> 필드값에 대해 초기화 값을 인수로 가지는 생성자 즉, this.id = id 이런식
public class Member {

    //Member 번호
    @Id
    private Integer id;

    //Member 이름
    private String name;


}
