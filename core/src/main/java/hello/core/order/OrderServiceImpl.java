package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

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
    
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //객체에서 final 을 사용하면 참조타입을 변경할 수 없다. 그러나 생성된 객체의 주소를 저장하는 방식이이게 만약 arraylist를 생성했다고,
    //가정하면 arraylist의 내부 값은 변경이 가능하다 . 이같은 점이 변수에 final 을 선언하는 것과의 차이이다.

    
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }











    

}
