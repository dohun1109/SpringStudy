package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository() 호출
    //@Bean orderService -> new MemoryMemberRepository() 호출

    /**
     * 위와 같은 상황이면 new MemoryMemberRepository()가 2번 호출되며 생성되니까 싱글톤이 깨지는거 아니냐? 라고
     * 생각 할 수 있다 .그러나
     */


    /**
     * 호출시 어떤 매소드가 얼마나 호출 되는지 예상
     * 1. call AppConfig.memberService
     * 2. call AppConfig.memberRepository

     * 1. call AppConfig.orderService
     * 2. call AppConfig.memberRepository

     * 1. call AppConfig.memberRepository
     * 결과적으로 memberRepository 가 3번 호출 
     */

    /**
     * 셀제로 테스시 호출되는 결과
     * call AppConfig.memberService -1번
     * call AppConfig.memberRepository -1번
     * call AppConfig.orderService -1번
     * commit 
     */

    @Bean   //스프링 컨테이너 등록
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService ");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), getDiscountPolicy());
    }

    @Bean
    public static DiscountPolicy getDiscountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}
