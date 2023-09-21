package com.example.SpringDataJDBCSample;

import com.example.SpringDataJDBCSample.entity.Member;
import com.example.SpringDataJDBCSample.repository.MemberCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJdbcSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcSampleApplication.class, args).getBean(SpringDataJdbcSampleApplication.class).execute();

    }

    @Autowired
    //스프링 프레임워크에 의해 생성된 인스턴스를 이용하는 클래스에
    // 참조를 받는 필드를 선언하고 필드에 어노테이션 부여.
    MemberCrudRepository repository;


    /*
    *	등록과 전체 취득 처리
    * */
    private void execute() {
        //등록
        executeInsert();

        //전체 취득
        executeSelect();
    }

    //등록 method
    private void executeInsert() {
        //Entity 생성(id는 자동 부여되기 때문에 null을 설정)
        Member member = new Member(null, "이순신");
        //repository 를 이용해서 등록하고 결과를 취득
        member = repository.save(member);
        //결과를 표시
        System.out.println("등록 데이터 " + member);
    }

    //전체 취득 method
    private void executeSelect() {
        System.out.println("--- 전체 데이터를 취득합니다. ---");

		//repository 를 통해 전체 데이터를 취득
		Iterable<Member> members = repository.findAll();
		for (Member member : members) {
			System.out.println(member);
		}
    }


}
