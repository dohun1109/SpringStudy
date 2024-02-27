package kr.co.hanbit.product.management2.presentation;

import jakarta.validation.constraints.NotNull;
import kr.co.hanbit.product.management2.domain.Product;

import java.util.Objects;

public class ProductDto {

    /*  MethodArgumentNotValidException
    *   도메인 객체에 대한 유효성 검사를 할 때와는 다르게 400에러가 잘떨어진다.
    *   하지만 응답바디에는 어떤 필드가 왜 유효성 검사에 실패했는지는 나와있지 않다. 즉, 전역 예외핸들러가 필요한 순간
    * */

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer price;
    @NotNull
    private Integer amount;

    public ProductDto(){}
    
    public ProductDto(String name, Integer price, Integer amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public ProductDto(Long id, String name, Integer price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public void setId(Long id) {
        this.id = id;
    }


    public static Product toEntity(ProductDto productDto) { //ProductDto -> Product
        Product product = new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getAmount()
        );
        return product;
    }

    public static ProductDto toDto(Product product) {       //Product -> ProductDto
        ProductDto productDto = new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getAmount()
        );

        return productDto;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        ProductDto productDto = (ProductDto) obj;
        return Objects.equals(id, productDto.id);
    }





}
