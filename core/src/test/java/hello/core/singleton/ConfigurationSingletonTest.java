package hello.core.singleton;

import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.AppConfig;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {


    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //원래는 구체타입으로 꺼내면 안좋지만 일단 테스트를 위해 사용
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);

        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);


        //1번과 2번이 상식적으로 같아야하는데 과연 어떻지 테스트 
        MemberRepository memberRepository1 = memberService.getMemberRepository();                             
        MemberRepository memberRepository2 = orderService.getMemberRepository();


        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberRepository1).isSameAs(memberRepository2);
        assertThat(memberRepository2).isSameAs(memberRepository);
        assertThat(memberRepository1).isSameAs(memberRepository);


    }


    @Test
    void configurationDeep(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);    //스프링 빈으로 등록 
        AppConfig bean = ac.getBean(AppConfig.class);   //클래스 타입

        System.out.println("bean.getClass() = " + bean.getClass());
        //위 코드로 알수 있는 점
        /**
         *  클래스명에 xxxCGLIB가 붙으면서 상당히 복잡해졌다. 이거승ㄴ 내가 만든 클래스가 아니라 스프링이 CGLIB라는 바이트코드 조작 라이브러리를 사용해서 AppConfig 클래스를 상속받은 임의의 다른 클래스를 만들고, 그 다른 클래스를 빈으로 등록한 것이다.
         */
          
    }
    


}
