package kr.co.hanbit.product.management2.infrastructure;


import kr.co.hanbit.product.management2.domain.EntityNotFoundException;
import kr.co.hanbit.product.management2.domain.Product;
import kr.co.hanbit.product.management2.domain.ProductRepository;
import kr.co.hanbit.product.management2.presentation.ProductDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Profile("test")
public class ListProductRepository implements ProductRepository {

    private List<Product> products = new CopyOnWriteArrayList<>();
    /* 웹 애플리케이션이 여러 개의 스레드가 동시에 작동하는 멀티스레드라는 특수한 환경 때문에 '스레드 세이프'한 컬렉션을 사용해야함.*/
    private AtomicLong sequence = new AtomicLong(1L);
    /* 클라이언트가 보내는 id로 상품 번호를 만들면 중복된 상품 번호가 생성되거나, 사용자가 보낸 요청이 실패할 가능성이 높다.
     * 예를 들어, 좌석 예매 선착순 요청이 있다고 할 때 클라이언트가 선택가능한 좌석을 응답받고 다시 신청하게 되면 실제로는 다른 클라이언트의 요청이 먼저 받아들여저 해당 클라이언트가 요청할 시점에는 이미 선택된 좌석인것과 비슷하다((중복이 생기는 상활을)서버에서 처리한 것 만약 이러한 처리가 되지 않는다면 중복된 사용자가 자리를 중복선택하게됨).
     * 또한, AtomicLong 도 스레드 세이프한 클래스
     * */


    public Product add(Product product) {

        product.setId(sequence.getAndAdd(1L));

        products.add(product);
        return product;
    }

    public Product findById(Long id) {
        return products.stream()
                .filter(product -> product.sameId(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Product 를 찾지 못했습니다."));
    }

    public List<Product> findAll(){
        return products;
    }

    public List<Product> findByNameContaining(String name) {
        return products.stream()
                .filter(product -> product.containsName(name))
                .toList();
    }


    public Product update(Product product) {

        Integer indexToModify = products.indexOf(product);
        products.set(indexToModify, product);
        return product;
    }

    public void delete(Long id) {

        Product product = this.findById(id);
        products.remove(product);
    }
}
