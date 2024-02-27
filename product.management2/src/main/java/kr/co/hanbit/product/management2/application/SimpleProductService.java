package kr.co.hanbit.product.management2.application;


import kr.co.hanbit.product.management2.domain.Product;
import kr.co.hanbit.product.management2.domain.ProductRepository;
import kr.co.hanbit.product.management2.presentation.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleProductService {



    private ValidationService validationService;

    private ProductRepository productRepository;


    @Autowired      //생성자 주입 방식으로 ValidationService 와 ProductRepository 를 주입받는다 .
    SimpleProductService(
             ValidationService validationService
            , ProductRepository productRepository

    ) {
        this.productRepository = productRepository;
        this.validationService = validationService;
    }

    public ProductDto add(ProductDto productDto) {

        // 1. ProductDto 를 Product로 변환하는 코드
        Product product = ProductDto.toEntity(productDto);
        validationService.checkValid(product);
        
        // 2. repository 를 호출하는 코드
        Product savedProduct = productRepository.add(product);

        // 3. Product 를 ProductDto 로 변환하는 코드
        ProductDto savedProductDto = ProductDto.toDto(savedProduct);

        // 4. DTO 를 반환하는 코드
        return savedProductDto;
    }

    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id);
        ProductDto productDto = ProductDto.toDto(product);
        return productDto;
    }

    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = products.stream()
                .map(product -> ProductDto.toDto(product))
                .toList();
        return productDtos;
    }

    public List<ProductDto> findByNameContaining(String name) {
        List<Product> products = productRepository.findByNameContaining(name);
        List<ProductDto> productDtos = products.stream()
                .map(product -> ProductDto.toDto(product))
                .toList();
        return productDtos;
    }


    public ProductDto update(ProductDto productDto) {
        Product product = ProductDto.toEntity(productDto);
        Product updatedProduct = productRepository.update(product);
        ProductDto updatedProductDto = ProductDto.toDto(updatedProduct);
        return updatedProductDto;
    }

    public void delete(Long id) {
        productRepository.delete(id);
    }



    
}
