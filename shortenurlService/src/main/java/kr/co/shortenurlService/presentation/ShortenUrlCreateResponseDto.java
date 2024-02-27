package kr.co.shortenurlService.presentation;

import kr.co.shortenurlService.domain.ShortenUrl;

public class ShortenUrlCreateResponseDto {

    private String originalUrl;
    private String shortenUrlKey;

    public ShortenUrlCreateResponseDto(ShortenUrl shortenUrl) {
        this.originalUrl = shortenUrl.getOriginalUrl();
        this.shortenUrlKey = shortenUrl.getShortenURlKey();
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    
    public String getShortenUrlKey() {
        return shortenUrlKey;
    }
    
    

}
