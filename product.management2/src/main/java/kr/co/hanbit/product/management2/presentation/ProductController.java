package kr.co.hanbit.product.management2.presentation;

import jakarta.validation.Valid;
import kr.co.hanbit.product.management2.application.SimpleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private SimpleProductService simpleProductService;

    @Autowired
    ProductController(SimpleProductService simpleProductService) {
        this.simpleProductService = simpleProductService;
    }


    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ProductDto createProduct(@Valid @RequestBody ProductDto productDto) {
        //Product를 생성하고 리스트에 넣는 작업이 필요함.
        return simpleProductService.add(productDto);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ProductDto findProductById(@PathVariable Long id) {
        return simpleProductService.findById(id);
    }

    @RequestMapping(value = "/products/all", method = RequestMethod.GET)
    public List<ProductDto> findAllProduct() {
        return simpleProductService.findAll();
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<ProductDto> findProducts(@RequestParam(required = false) String name) {
        //@RequestParam 은 기본속성이 파라미터를 필수로 받도록 하기때문에 400 에러 방지 
        if (null == name) return simpleProductService.findAll();
        return simpleProductService.findByNameContaining(name);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ProductDto updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDto productDto
    ) {
        productDto.setId(id);   //요청 바디로 id를 넣어주지 않을 수도 있기 때문이다.
        return simpleProductService.update(productDto);
        //현재 update 문의 경우 index 를 기준으로 수정하는 동작으로 인해 스레드 안전하지 않다.
    }


    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable Long id) {
        simpleProductService.delete(id);
    }
}
