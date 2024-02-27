package kr.co.shortenurlService.application;

import kr.co.shortenurlService.domain.NotFoundShortenUrlException;
import kr.co.shortenurlService.presentation.ShortenUrlCreateRequestDto;
import kr.co.shortenurlService.presentation.ShortenUrlCreateResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleShortenUrlServiceTest {


    @Autowired
    private SimpleShortenUrlService simpleShortenUrlService;


    @Test
    @DisplayName("URL 을 단축한 후 단축된 URL키로 조회하면 원래 URL이 조회되어야 한다.")
    void shortenUrlAddTest(){
        String expectedOriginalUrl = "https://www.hanbit.co.kr/";
        ShortenUrlCreateRequestDto shortenUrlCreateRequestDto = new ShortenUrlCreateRequestDto(expectedOriginalUrl);

        ShortenUrlCreateResponseDto shortenUrlCreateResponseDto = simpleShortenUrlService.generateShortenUrl(shortenUrlCreateRequestDto);
        String shortenUrlKey  = shortenUrlCreateResponseDto.getShortenUrlKey();
        String originalUrl = simpleShortenUrlService.getOriginalUrlByShortenUrlKey(shortenUrlKey);
    }


    // 존재하지 않은 단축 URL을 조회하는 경우 테스트 코드 작성해보기
    @Test
    @DisplayName("존재하지 않는 단축 URL을 조회하는 경우 NotFoundShortenUrlException이 발생해야 한다.")
    void getNonExistentShortenUrlTest() {
        // 존재하지 않는 단축 URL 키 생성
        String nonExistentShortenUrlKey = "non-existent-key";

        // 존재하지 않는 단축 URL 조회 시도
        assertThrows(NotFoundShortenUrlException.class, () -> {
            simpleShortenUrlService.getOriginalUrlByShortenUrlKey(nonExistentShortenUrlKey);
        });
    }

    
}
