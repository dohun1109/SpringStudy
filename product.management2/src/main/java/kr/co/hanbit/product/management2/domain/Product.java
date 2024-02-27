package kr.co.hanbit.product.management2.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Product {
    
    private Long id;
    @Size(min = 1, max = 100)
    private String name;
    @Max(1_000_000)
    @Min(0)
    private Integer price;

    public Product(){
    }
    public Product(Long id, String name, Integer price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    @Max(9_999)
    @Min(0)
    private Integer amount;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }


    // ConstraintViolationException
    // HTTP 응답 상태 코드중 파라미터를 잘못 보낸경우 400BadGate Request 를 응답해야한다.
    // 하지만 전역예외 핸들러를 추가하기 전인 시점에서는 500 Error 가 반환된다.
    // 위의 경우 애플리케이션 layer 에서 발생한 에러인데 예외를 처리하지 않고 컨트롤러 까지 Throw 되고 있다.
    // 이러한 이유로 전역 예외 핸들러를 추가하여 예외에 적절한 상태코드로 반환해 주도록 한다.



    public boolean sameId(Long id) {
        return this.id.equals(id);
    }

    public Boolean containsName(String name){
        /* getter 를 사용하지 않고 method 작성이유
        *  getName 이 아닌 containsName 으로 작성한 이유는 getter 로
        *  값을 직접가져와서 사용하면 객체지향적인 코드가 아니라 값이 여러 곳에서 중복사용된 절차지향적인 코드가
        *  된다. 또한 Product 가 단순히 값을 저장하는 객체가 되고, 요구사항에 나와있는 상품이라는 도메인지식이
        *  Product 내부가 아닌 애플리케이션 전체로 퍼져서 코드만으로는 요구사항(의도) 맥락을 파악하기 어려워 진다.
        *  캡슐화를 유지하기 위해서 getter,setter 의 사용을 최대한 지양하라는 것과 같은 맥락이다.
        *  이로인해 요구사항이 급변하고 추가되는 도메인 주도 설계(DDD) 에서 빛을 발한다.
        * */
        return this.name.contains(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(id, product.id);
    }
    
}
