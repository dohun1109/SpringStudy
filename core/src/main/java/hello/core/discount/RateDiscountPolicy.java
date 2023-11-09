package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
//@Primary    // 우선순위를 최상위로 설정
// 보통 @Primary 와 @Qualifier 중에 어떤 것을 사용하면 좋을지 고민이 될 것이다.
// @Qualifier 의 단점은 주입 받을 때 모든 코드에 애노테이션을 붙여줘야 하는 것이다 .
// 그래서 보통 메인DB 와 서브DB 가 있다고 치면, 메인DB 는 @Primary 를 붙이고
// 서브 DB 는 @Qualifier 를 설정해 주어서 필요시 사용한다 .

// 스프링은 자동 보다 수동이 우선순위가 높다.
// 그래서 @primary 와 @qualifier 가 둘다 있을 때 @qualifier 가 우선순위가 더 높다

@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
    private  int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
      
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }

    
}
