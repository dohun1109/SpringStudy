package kr.co.shortenurlService.domain;

public interface ShortenUrlRepository {

    void saveShortenUrl(ShortenUrl shortenUrl);

    ShortenUrl findShortenUrlByShortenUrlKey(String shortenUrlKey);

    
}
