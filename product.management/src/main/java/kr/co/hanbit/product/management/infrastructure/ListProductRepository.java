package kr.co.hanbit.product.management.infrastructure;



import kr.co.hanbit.product.management.domain.EntityNotFoundException;
import kr.co.hanbit.product.management.domain.Product;
import kr.co.hanbit.product.management.domain.ProductRepository;
import kr.co.hanbit.product.management.presentation.ProductDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Profile("test")
public class ListProductRepository implements ProductRepository {


    private List<Product> products = new CopyOnWriteArrayList<>();
    private AtomicLong sequence = new AtomicLong(1L);   //Id 의 값을 1로 초기화

    public Product add(Product product) {
        product.setId(sequence.getAndAdd(1L));  //요청할 때마다 1씩증가
        products.add(product);
        return product;
    }


    public Product findById(Long id) {  //filter 를 거쳐 요청한 id(상품 번호)와 같은 Product 만을 뽑아낸다.       
        return products.stream()
                .filter(product -> product.sameId(id))  //파라미터로 받은 id 와 Product 인스턴스의 id 와 비교 하여 True, false return
                .findFirst()
                .orElseThrow(()-> new EntityNotFoundException("Product를 찾지 못했습니다."));
    }


    public List<Product> findAll() {
        return products;
    }


    public List<Product> findByNameContaining(String name) {
        return products.stream()
                .filter(product -> product.containName(name))
                .toList();
    }

    public Product update(Product product) {
        Integer indexToModify = products.indexOf(product); //해당 방식은 Index를 기준으로 수정할 Product가 선택됨으로 멀티스레드 환경에서 Product 가 추가되거나 삭제되면 수정하려는 id의 Product 가 아니라 엉뚱한 Product 가 수정될 것이다. (자바 동시성 프로그래밍 배워야함...)
        products.set(indexToModify, product);
        return product;
//        Long productId = updatedproduct.getId();
//
//        synchronized (products) {
//            for (int i = 0; i < products.size(); i++) {
//                Product product = products.get(i);
//                if (product.getId().equals(productId)) {
//                    //여기에서는 setter를 사용하지 않고 직접 필드를 수정하는 방식으로 업데이트 합니다.
//                    products.set(i, new Product(productId, updatedproduct.getName(),  updatedProduct.getPrice()));
//                    return upatedProduct;
//                }
//            }
//        }
//       throw new IllegalArgumentException("ID가 " + productId + "인 제품을 찾을 수 없습니다.");
        
    }

    public void delete(Long id) {
        Product product = this.findById(id);
        products.remove(product);
    }
}
