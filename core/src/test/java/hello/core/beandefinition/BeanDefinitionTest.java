package hello.core.beandefinition;

import hello.core.order.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    //AnnotationConfigApplicationContext -> 자바파일에서 빈생성 (리더를 통해 메타 데이터 생성) 
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    // ... xml 파일에서의 빈생성 ( 리더를 통해 메타데이터를 생성한다.)
    GenericXmlApplicationContext gac = new GenericXmlApplicationContext("appConfig.xml");

    @Test
    @DisplayName("빈 설정 메타 정보 확인")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName +
                        "beanDefinition = " + beanDefinition);
            }
        }
    }

    @Test
    @DisplayName("빈 설정 메타 정보 확인(xml)")
    void findXmlApplicationBean() {
        String[] beanDefinitionNames = gac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = gac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName +
                        "beanDefinition = " + beanDefinition);
            }
        }
    }











}
