package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
        //스프링 컨테이너를 종료 -> ConfigurableApplicationContext 가 필요
        //종료 하는 부분같은 경우 자주 안쓰이기 때문에 ApplicationContext 에 구현이 되어있지 않고
        //그보다 좀 더 하위 개념인 ConfigurableApplicationContext 에 구현되어 있다.
        //ConfigurableApplicationContext 같은 경우 AnnotationConfigApplicationContext 의 상위 인터페이스로 타입 선언?
        // 자식을 부모한테 담을 수 있게 된다.  


    }


    
    @Configuration 
    static class LifeCycleConfig{
//        @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            //빈 생성 lifeCycle 에서 생성자 주입의 경우 빈이 생성될때  객체가 생성됨으로
            //객체가 생성된 후에 url 값을 바꾸려 하기때문에 null 이 들어가게 된다.
            /*
             *  초기화 콜백 : 빈이 생성되고, 빈의 의존관계 주입이 안료된 후 호출된다.
             *  소멸 전 콜백 : 빈이 소멸되기 직전에 호출된다.
             */

            return networkClient;

        }

    }








}
