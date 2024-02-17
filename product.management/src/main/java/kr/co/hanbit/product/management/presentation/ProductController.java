package kr.co.hanbit.product.management.presentation;


import jakarta.validation.Valid;
import kr.co.hanbit.product.management.application.SimpleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// 상품 추가를 위한 컨트롤러

@RestController         //@Service 의 의존성을 주입받는다.
public class ProductController {

    private SimpleProductService simpleProductService;

    @Autowired
    ProductController(SimpleProductService simpleProductService) {
        this.simpleProductService = simpleProductService;
    }


    @RequestMapping(value = "/products", method = RequestMethod.POST) //상품 추가
    public ProductDto createProduct(@Valid @RequestBody ProductDto productDto) {
        //Product 를 생성하고 리스트에 넣는 작업이 필요함
        return simpleProductService.add(productDto);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)   //단일 상품 조회
    public ProductDto findProductById(@PathVariable Long id) {
        return simpleProductService.findById(id);
    }

    @RequestMapping(value = "/products/all", method = RequestMethod.GET)    //상품 전체 조회
    public List<ProductDto> findAllProduct() {
        return simpleProductService.findAll();
    }

    @RequestMapping(value = "/products/search/", method = RequestMethod.GET)    //상품이름에 포함된 문자열로 검색
    public List<ProductDto> findProducts(@RequestParam(required = false) String name) {
        if (null == name) {
            return simpleProductService.findAll();
        }
        return simpleProductService.findByNameContaining(name);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ProductDto updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDto productDto
    ) {
        productDto.setId(id);
        return simpleProductService.update(productDto);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable Long id) {
        simpleProductService.delete(id);
    }
}



