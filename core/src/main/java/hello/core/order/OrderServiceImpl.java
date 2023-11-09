package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor    //미친 놈
public class OrderServiceImpl implements OrderService {


     private final MemberRepository memberRepository;
    //객체에서 final 을 사용하면 참조타입을 변경할 수 없다. 그러나 생성된 객체의 주소를 저장하는 방식이이게 만약 arraylist를 생성했다고,
    //가정하면 arraylist의 내부 값은 변경이 가능하다 . 이같은 점이 변수에 final 을 선언하는 것과의 차이이다.
    //코드가 간결해서 좋지만, 외부에 테스트하기가 어렵다 private 그래서 관정하지 않음. (필드 주입)  


    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); -> DIP 위반
   private final  DiscountPolicy discountPolicy; //-> final 은 반드시 값이 할당 되어야 한다.f
    //NUll pointer Exception
    //코드가 간결해서 좋지만, 외부에 테스트하기가 어렵다 private 그래서 관정하지 않음. (필드 주입) 

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
////        System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }
//    @Autowired
//    public void setDiscountPolicy(@Qualifier("rateDiscountPolicy") DiscountPolicy discountPolicy) {
////        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }
    
    // 즉, 불변성을 띈다는 뜻이다.
    //그리고, 추가적으로 생성자가 딱 1개만 있다면 @Autowired를 생략해도 자동으로 주입이 된다.물론 스프링 빈에만 해당된다.


    
    @Autowired     //생성자 생성을 통해 의존관계가 주입됨으로 생성자 생성 시점에 딱 1번만 호출되고 그뒤로는 접근하거나 다시 호출 할 수 없게된다.
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        System.out.println("1. OrderServiceImple.OrderServiceImpl");
//        System.out.println("memberRepository = " + memberRepository);
//        System.out.println("discountPolicy = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     * 자바 에서 final 키워드는 여러 컨텍스트에서 단 한 번만 할당 될 수 있는 entity 를 정의할
     * 때 사용된다.
     * final 키워드는 총 3가지에 적용할 수 있습니다.
     *  '''
     * final 변수
     *  -원시 타입 : 로컬 원시 변수에 final로 선언하면 초기화된 변수는 변경할 수 없는 상수값이 됩니다.
     *  -객체 타입 : 객체 변수에 final 로 선언할면 그 변수에 다른 참조 값을 지정할 수 없습니다. 원시 타입과
     *      동일하게 한번 쓰여진 변수는 재변경이 불가합니다. 단, 객체 자체가 Immutable 하다는 의미는 아닙니다. 객체의 속성은 변경가능
     *  -클래스 필드 :
     *  -메소드 인자 : 메서드인자에 final 키워드를 붙이면, 메서드 안에서 변수 값을 변경할 수 없습니다.
     *  '''
     * final 메소드
     * final 클래스
     */
    

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
