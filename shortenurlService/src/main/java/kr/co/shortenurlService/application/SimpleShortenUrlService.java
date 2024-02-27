package kr.co.shortenurlService.application;


import kr.co.shortenurlService.domain.LackOfShortenUrlKeyException;
import kr.co.shortenurlService.domain.NotFoundShortenUrlException;
import kr.co.shortenurlService.domain.ShortenUrl;
import kr.co.shortenurlService.domain.ShortenUrlRepository;
import kr.co.shortenurlService.presentation.ShortenUrlCreateRequestDto;
import kr.co.shortenurlService.presentation.ShortenUrlCreateResponseDto;
import kr.co.shortenurlService.presentation.ShortenUrlInformationDto;
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
         *       - 단축된 URL 의 키는 8글자로 생성, '단축된 URL 의 키'는 'https://bit.ly/3onGWgk'에서 Path = '3onGWgk' 를 의미한다.
         *       - 키생성 알고리즘은 자유롭게 구현하면된다. (+ Base56 인코딩 방식의 랜덤 키 생성알고리즘 ShortenUrl 추가)
         *   2. 원래의 Url 과 단축 Url 키를 통해 ShortenUrl 도메인 객체 생성
         *   3. 생성된 ShortenUrl 을 레포지토리를 통해 저장
         *   4. ShortenUrl 을 ShortenUrlCreateResponseDto 로 변환하여 반환
         * */
        String originalUrl = shortenUrlCreateRequestDto.getOriginalUrl(); //Client 에게 요청된 OriginUrl 받아와서
        String shortenUrlKey = getUniqueShortenUrlKey();    // Random 으로 key 값 생성 및 중복체크
        
        ShortenUrl shortenUrl = new ShortenUrl(originalUrl, shortenUrlKey); //OriginalUrl 과 shortenUrlKey 파라미터로 ShortenUrl 생성
        shortenUrlRepository.saveShortenUrl(shortenUrl);    //HashMap 형태의 메모리에 저장

        ShortenUrlCreateResponseDto shortenUrlCreateResponseDto = new ShortenUrlCreateResponseDto(shortenUrl);   //Dto 로 변환
        return shortenUrlCreateResponseDto; //Controller 쪽으로 return 
    }


    public ShortenUrlInformationDto getShortenUrlInformationByShortenUrlKey(String shortenUrlKey) {
        ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);

        if (null == shortenUrl) {
            throw new NotFoundShortenUrlException();
        }
        ShortenUrlInformationDto shortenUrlInformationDto = new ShortenUrlInformationDto(shortenUrl);

        return shortenUrlInformationDto;
    }


    public String getOriginalUrlByShortenUrlKey(String shortenUrlKey) {

        ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);

        if (null == shortenUrl) {
            throw new NotFoundShortenUrlException();
        }

        shortenUrl.increaseRedirectCount();
        shortenUrlRepository.saveShortenUrl(shortenUrl);

        String originalUrl = shortenUrl.getOriginalUrl();
        return originalUrl;
    }



    private String getUniqueShortenUrlKey(){
        final int MAX_RETRY_COUNT = 5;
        int count = 0;

        while (count++ < MAX_RETRY_COUNT) {
            String shortenUrlKey = ShortenUrl.generateShortenUrlKey();          //Random 으로 ShortenUrlKey 생성
            ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);

            if (null == shortenUrl) {
                return shortenUrlKey;
            }
        }
        throw new LackOfShortenUrlKeyException();
    }


}
