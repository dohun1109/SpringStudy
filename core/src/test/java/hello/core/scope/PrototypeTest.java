package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class PrototypeTest {


    @Test
    void PrototypeFind(){

        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototypeBean1");
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean bean2 = ac.getBean(PrototypeBean.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        assertThat(bean1).isNotSameAs(bean2);


        bean1.destroy();
        bean2.destroy();
        

        ac.close(); //prototype Scope 의 경우 클라이언트에서 요청시 초기화를 하고 응답을 한다. 그런데 응답시 스프링 컨테이너에서
        //관리 대상에서 제외 대기때문에 이후에는 클라이언트에게 책임이 전가 된다. 그래서 만약 종료해야 된다면
        //수동으로 메소드를 호출해서 닫아주는(실제로 현재 코드에서는 메소드 호출한다고 해서 닫히는건 아니고 닫이느 close 를 이후에 실행주는 거다.) 방법이 있다.

    }


    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init(){
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("SingletonBean.destroy");
        }
    }





}
