package hello.core.lifecycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
//    implements InitializingBean, DisposableBean
    //인터페이스로 빈을 초기화, 소멸 시점을 호출 받아서 사용하는 방식은 상당히 레거시 한 방식이다.
    //이 방식 이후에  좋은 방식들이 나와서 잘은 사용하지 않는다. 


    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }


    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect = " + url);

    }

    public void call(String message) {
        System.out.println("call : " + url + "message = " + message);
    }

    //서비스 종료시 호출 
    public void disconnect() {
        System.out.println("close : " + url);
    }


    @PostConstruct
    public void init() { //스프링 빈 생성이 완료되면 호출되는 method
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

     @PreDestroy
    public void close (){
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
