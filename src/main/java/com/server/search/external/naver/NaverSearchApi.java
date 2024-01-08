package com.server.search.external.naver;

import com.server.search.external.ExternalInterface;
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
@Service
public class NaverSearchApi implements ExternalInterface {
    @Value("${spring.naver.client_id}")
    private String clientId;
    @Value("${spring.naver.client_secret}")
    private String clientSecret;
    private ExternalInterface nextExternal;
    @Override
    public String search(String query, String sort) {
        ByteBuffer buffer = StandardCharsets.UTF_8.encode(query);
        String encode = StandardCharsets.UTF_8.decode(buffer).toString();
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query", encode)
                .queryParam("sort", sort)
                .encode()
                .build()
                .toUri();

        HttpHeaders requestHeadres = new HttpHeaders();
        requestHeadres.set("X-Naver-Client-Id", clientId);
        requestHeadres.set("X-Naver-Client-Secret", clientSecret);

        HttpEntity<String> entity = new HttpEntity<>(requestHeadres);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        return result.getBody();
    }
    @Override
    public void setNextExternal(ExternalInterface externalInterface) {
        nextExternal = externalInterface;
    }
}
