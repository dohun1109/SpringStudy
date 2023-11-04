package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@Component 어노테이션이 붙은 클래스들을 다 찾아서 @Bean으로 등록한다.
@ComponentScan(
//        basePackages = "hello.core.member", //어디서 부터 찾는지 시작지점 지정(이게 없으면 모든 자바코드 및 라이브러리까지 다 뒤저본다, 오래걸린다.)
//        basePackageClasses = AutoAppConfig.class,

        // 위의 범위를 지정하지 않고 default 로 설정하게 되면, 현재 @ComponentSacn 이 있는 클래스의
        //패키지 하위를 전부 탐색환다.

        /* 권장하는 방법
        * 패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는것이다.
        * 최근에 스프링부트도 이 방법을 기본으로 제공한다. 
        * */


        //컴포넌트 스캔을 통해 검사를 하게 되면 @Bean 으로 등록하게 되는데
        //등록할 때 등록되지 않도록 필터링 하는 것들을 정의 하는 것.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
     


}
