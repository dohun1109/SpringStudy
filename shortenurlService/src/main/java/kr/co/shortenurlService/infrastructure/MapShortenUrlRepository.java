package kr.co.shortenurlService.infrastructure;

import kr.co.shortenurlService.domain.ShortenUrl;
import kr.co.shortenurlService.domain.ShortenUrlRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


@Repository
public class MapShortenUrlRepository implements ShortenUrlRepository {


    private Map<String, ShortenUrl> shortenUrls = new ConcurrentHashMap<>();



    @Override
    public void saveShortenUrl(ShortenUrl shortenUrl) {
        shortenUrls.put(shortenUrl.getShortenURlKey(), shortenUrl); //key: shortenUrl Key, value: shortenUrl
    }

    @Override
    public ShortenUrl findShortenUrlByShortenUrlKey(String shortenUrlKey) {

        ShortenUrl shortenUrl = shortenUrls.get(shortenUrlKey);
        return shortenUrl;
    }
}
