package kr.co.shortenurlService.presentation;

import kr.co.shortenurlService.domain.ShortenUrl;

public class ShortenUrlCreateResponseDto {

    private String originalUrl;
    private String shortenUrlKey;

    public ShortenUrlCreateResponseDto(String originalUrl, String shortenUrlKey) {
        this.originalUrl = originalUrl;
        this.shortenUrlKey = shortenUrlKey;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    
    public String getShortenUrlKey() {
        return shortenUrlKey;
    }

    

}
