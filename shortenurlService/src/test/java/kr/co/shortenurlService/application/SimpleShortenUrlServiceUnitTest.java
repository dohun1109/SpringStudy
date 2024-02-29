package kr.co.shortenurlService.application;


import kr.co.shortenurlService.domain.LackOfShortenUrlKeyException;
import kr.co.shortenurlService.domain.NotFoundShortenUrlException;
import kr.co.shortenurlService.domain.ShortenUrl;
import kr.co.shortenurlService.domain.ShortenUrlRepository;
import kr.co.shortenurlService.presentation.ShortenUrlCreateRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SimpleShortenUrlServiceUnitTest {

    @Mock
    private ShortenUrlRepository shortenUrlRepository;

    @InjectMocks
    private SimpleShortenUrlService simpleShortenUrlService;

    @Test
    @DisplayName("단축 URL 이 계속 중복되면 LackOfShortenUrlKeyException 예외가 발생해야한다.")
    void throwLackOfShortenUrlKeyExceptionTest(){



        //given(준비): 어떠한 데이터가 준비되었을 때
        ShortenUrlCreateRequestDto shortenUrlCreateRequestDto = new ShortenUrlCreateRequestDto(null);

        //when(실행): 어떠한 함수를 실행하면
        when(shortenUrlRepository.findShortenUrlByShortenUrlKey(any())).thenReturn(new ShortenUrl(null, null));

        //then(검증): 어떠한 결과가 나와야 한다.
        assertThrows(LackOfShortenUrlKeyException.class, ()->{
            simpleShortenUrlService.generateShortenUrl(shortenUrlCreateRequestDto);
        });
    }

    @Test
    @DisplayName("단축 URL 을 찾지 못할 경우 NotFoundShortenUrlException ")
    void throwNotFoundShortenUrlExceptionTest(){

        //given(준비): 어떠한 데이터가 준비되었을 때
        String nonExistentShortenUrlKey = "non-existent-key";

        //when(실행): 어떠한 함수를 실행하면
        when(shortenUrlRepository.findShortenUrlByShortenUrlKey(nonExistentShortenUrlKey))
                .thenReturn(null);

        //then(검증): 어떠한 결과가 나와야 한다.
        assertThrows(NotFoundShortenUrlException.class, () -> {
            simpleShortenUrlService.getOriginalUrlByShortenUrlKey(nonExistentShortenUrlKey);
        });
    }
    

}