package com.ync.PathVariableSample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PathVariableController {
    @GetMapping("show")
    public String showView() {

        return "show";
    }

    //링크처리
    @GetMapping("/function/{no}")
    public String selectFunction(@PathVariable Integer no) {
        //뷰 이름을 초기화
        String view = "function0";

        switch (no) {
            case 1:
                view = "function1";
                break;
            case 2:
                view = "function2";
                break;
            case 3:
                view = "function3";
                break;
        }
        //반환값으로 뷰 이름을 돌려줌.
        return view;
    }
//    버튼 A클릭 처리
    @PostMapping(value = "send", params = "a")
    public String showAView(){
//        반환값으로 뷰 이름을 돌려줌
        return "a";
    }
    //    버튼 B클릭 처리
    @PostMapping(value = "send", params = "b")
    public String showBView(){
//        반환값으로 뷰 이름을 돌려줌
        return "b";
    }
    //    버튼 C클릭 처리
    @PostMapping(value = "send", params = "c")
    public String showCView(){
//        반환값으로 뷰 이름을 돌려줌
        return "b";
    }
}
