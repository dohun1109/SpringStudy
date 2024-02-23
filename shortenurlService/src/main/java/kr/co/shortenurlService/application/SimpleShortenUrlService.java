package kr.co.shortenurlService.application;


import kr.co.shortenurlService.domain.ShortenUrlRepository;
import kr.co.shortenurlService.presentation.ShortenUrlCreateRequestDto;
import kr.co.shortenurlService.presentation.ShortenUrlCreateResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleShortenUrlService {

    private ShortenUrlRepository shortenUrlRepository;

    @Autowired
    SimpleShortenUrlService(ShortenUrlRepository shortenUrlRepository) {
        this.shortenUrlRepository = shortenUrlRepository;
    }

    public ShortenUrlCreateResponseDto generateShortenUrl(
            ShortenUrlCreateRequestDto shortenUrlCreateRequestDto
    ) {
        /* method 해야할 일
        *   1. 단축 Url key 생성
        *   2. 원래의 Url 과 단축 Url 키를 통해 ShortenUrl 도메인 객체 생성
        *   3. 생성된 ShortenUrl 을 레포지토리를 통해 저장
        *   4. ShortenUrl 을 ShortenUrlCreateResponseDto 로 변환하여 반환  
        * */
        return null;
    }


}
