package kr.co.shortenurlService.domain;

import java.util.Random;

public class ShortenUrl {

    private String originalUrl;
    private String shortenURlKey;
    private Long redirectCount;

    public ShortenUrl(String originalUrl, String shortenURlKey) {
        this.originalUrl = originalUrl;
        this.shortenURlKey = shortenURlKey;
        this.redirectCount = 0L;
    }

    public static String generateShortenUrlKey() {

        String base56Characters = "23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";
        Random rnadom = new Random();
        StringBuilder shortenUrlKey = new StringBuilder();

        for (int count = 0; count < 8; count++) {
            int base56CharactersIndex = rnadom.nextInt(0, base56Characters.length());   //Base56 길이만큼의 수중 랜덤 선택
            char base56Character = base56Characters.charAt(base56CharactersIndex);      //랜덤한 index의 문자(char)을 뽑아서
            shortenUrlKey.append(base56Character);      //shortenUrlKey 에 추가 그렇게 총 8개의 랜덤한 문자를 저장
        }
        return shortenUrlKey.toString();    //생성한 랜덤 Url key return
    }


    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortenURlKey() {
        return shortenURlKey;
    }

    public Long getRedirectCount() {
        return redirectCount;
    }

    public void increaseRedirectCount() {
        this.redirectCount = this.redirectCount + 1;
    }
}
