package kr.co.shortenurlService.presentation;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController         //json data 전송 담당
public class ShortenUrlRestController {

    @RequestMapping(value = "/shortenUrl", method = RequestMethod.POST)  //1. 단축 URL 생성 API
    public ResponseEntity<ShortenUrlCreateResponseDto> createShortenUrl(
            @Valid @RequestBody ShortenUrlCreateRequestDto shortenUrlCreateRequestDto
    ) {
        return ResponseEntity.ok().body(null);
    }

    @RequestMapping(value = "/{shortenUrlKey}", method = RequestMethod.GET)  //2. 단축 URl 라다이렉트 API
    public ResponseEntity<?> redirectShortenUrl() {
        return ResponseEntity.ok().body(null);
    }

    @RequestMapping(value = "/shortenUrl/{shortenUrlKey}", method = RequestMethod.GET)  //3. 단축 URL 정보 조회 API
    public ResponseEntity<?> getShortenUrlInformation() {
        return ResponseEntity.ok().body(null);
    }
}
