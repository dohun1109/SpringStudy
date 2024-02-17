package kr.co.hanbit.product.management.application;

import kr.co.hanbit.product.management.domain.EntityNotFoundException;
import kr.co.hanbit.product.management.presentation.ProductDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@ActiveProfiles("prod")
public class SimpleProductServiceProd {

    @Autowired
    SimpleProductService simpleProductService;


    @Test
     @Transactional
    @DisplayName("상품을 추가한 후 id로 조회하면 해당 상품을 조회되어야 한다.")
    void productAddAndFindByIdTest() {

        ProductDto productDto = new ProductDto("연필", 300, 20);

        ProductDto savedProductDto = simpleProductService.add(productDto);
        Long savedProductId = savedProductDto.getId();
        ProductDto foundProductDto = simpleProductService.findById(savedProductId);

        assertTrue(savedProductDto.getId().equals(foundProductDto.getId()));
        assertTrue(savedProductDto.getName().equals(foundProductDto.getName()));
        assertTrue(savedProductDto.getPrice().equals(foundProductDto.getPrice()));
        assertTrue(savedProductDto.getAmount().equals(foundProductDto.getAmount()));

    }

    @Test
    @DisplayName("존재하지 않는 상품 id로 조회하면 EntityNotFoundException 이 발생해야한다.")
    void findProductNotExistIdTest() {
        Long notExistId = -1L;

        assertThrows(EntityNotFoundException.class, () -> {
            simpleProductService.findById(notExistId);
        });

    }

    @Test
    @Transactional
    @DisplayName("상품을 update 한 후 id로 조회하면 해당 부분이 변경되어야한다. ")
    void productFindAllTest() {
        ProductDto productDto = new ProductDto(11L,"수정됨", 111, 222);

        ProductDto updateProductDto = simpleProductService.update(productDto);
        Long updateProductId = updateProductDto.getId();
        ProductDto foundProductDto = simpleProductService.findById(updateProductId);

        assertTrue(updateProductDto.getId().equals(foundProductDto.getId()));
        assertTrue(updateProductDto.getName().equals(foundProductDto.getName()));
        assertTrue(updateProductDto.getPrice().equals(foundProductDto.getPrice()));
        assertTrue(updateProductDto.getAmount().equals(foundProductDto.getAmount()));


    }

    
}
