package hello.core.autoWired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {


    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
        

        
    }


    static class TestBean {
        /** 옵션 처리 
         *  주입할 스프링 빈이 없어도 동작해야 할 때가 있다 .
         * - @Autowired(required = false) : 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출안됨
         * - org.wpringframework.lang.@Nullable: 자동 주입할 대상이 없으면 null이 입력된다.
         * - Optional<> : 자동 주입할 대상이 없으면 Optional.empty가 입력 된다.
         */
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }
        
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public  void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }


    }





}
