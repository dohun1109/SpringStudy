package hello.core.singleton;

import hello.core.member.MemberService;
import hello.core.order.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleTonTest {
    /**
     * 우리가 만들었던 스프링 없는 순수한 Di 컨테이너인 AppConfig는 요청을 할 때 만다 객체를 새로 생성한다. 만약 고객의 트랙픽이 초당 100이 나오면 초당 100갸의 객체가 생성되고 소멸된다 -> 즉,메모리 낭비가 심하다.
     * 해결 방안은 해당 객체가 딱 1개만 생성되고, 공유하도록 설계하면 된다. -> 싱글톤 패턴
     */
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 != memberService2

        assertThat(memberService1).isNotSameAs(memberService2);
    }


    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체생성")
    void SingletonServiceTest() {
        //private으로 생성자를 막아두었다. 컴파일 오류가 발생한다. //new SingletonService();


        //1. 조회: 호출할 때 마다 같은 객체를 반환
        SingletonService singletonService1 = SingletonService.getInstance();
        //2. 조회: 호출할 때 마다 같은 객체를 반환
        SingletonService singletonService2 = SingletonService.getInstance();


        //참조값이 같은 것을 확인
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        // singletonService1 == singletonService2
        assertThat(singletonService1).isSameAs(singletonService2);
        //isSameAs == 참조 값을 비교 
        //equals Equals -> 값을 비교 
        singletonService1.logic();
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void SpringContainer() {
//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        //2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 != memberService2

        assertThat(memberService1).isSameAs(memberService2);


        /* 스프링 컨테이너 덕분에 고객의 요청이 올 때 마다 객체를 생성하는 것이 아니라, 이미 만들어진 객체를 공유해서 효율적으로 재사용
            할 수있다. 참고로 스프링의 기본 빈 등록 방식은 싱글톤이지만, 싱글톤 방식만 지원하는 것은 아니다. 요청할 때 마다 새로운 객체를
            생성해서 반환하는 기능도 제공한다.(Ex http request Life cycle 에 맞춰서 bean life cycle 을 맞추거나 이럴이럴 때)
             -> 자세한건 뒤에 빈스코프에서
         */

        

    }


    /*
     *  싱글톤 방식의 주의점
     * 싱글톤 패턴이든, 스프링 같은 싱글톤 컨테이너 사용하든, 객체 인스턴스를 하나만 생성해서 공유하는 싱글톤 방식은 여러 클라이언트가 하나의 객체 인스턴스를 공유하기 때문에 싱글톤 객체는 상태를 유지(stateful)하게 설계하면 안된다.
     *
     * 무상태(stateless)로 설계해야한다.
     * - 특정 클라이언트에 의존적인 필드가 있으면 안된다.
     * - 특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다!
     * - 가급적 읽기만(get o , set x) 가능해야 한다.
     * - 필드 대신에 자바에서 공유되지 않는, 지역변수, 파라미터, ThreadLocal 등을 사용해야 한다.
     * 스프링 빈의 필드에 공유 값을 설정하면 정말 큰 장애가 발생할 수 있다.
     */


}












