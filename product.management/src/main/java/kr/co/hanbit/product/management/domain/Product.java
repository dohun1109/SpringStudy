package kr.co.hanbit.product.management.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Product {


    private Long id;    //상품 번호( 식별자)   indexStart -> 1 add -> +1 상품이 서버에서 생성되는 시점
    // 클라이언트가 보내는 id로 상품번호를 만들면 중복된 상품 번호가 생성되거나, 사용자가 보낸 요청이 실패할 가능성이 있기 때문이다.

    @Size(min = 1, max = 100)
    private String name;    //상품 이름

    @Max(1_000_000)
    @Min(0)
    private Integer price; //상품 가격

    @Max(9_999)
    @Min(0)
    private Integer amount; //재고 수량

    public Product() {
        
    }
    public Product(Long id, String name, Integer price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }



    public boolean sameId(Long id) {
        return this.id.equals(id);
    }

    public boolean containName(String name) {
        return this.name.contains(name);
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
}
