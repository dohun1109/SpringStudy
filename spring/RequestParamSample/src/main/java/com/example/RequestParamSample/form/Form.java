package com.example.RequestParamSample.form;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data   //자동으로 getter/setter 생성
public class Form {
    private String name;
    private Integer age;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birth;

    
}
