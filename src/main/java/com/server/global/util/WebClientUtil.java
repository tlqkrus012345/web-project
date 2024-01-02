package com.server.global.util;

import com.server.global.config.WebClientConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WebClientUtil {

    private final WebClientConfig webClientConfig;

    public <T> T get(String url, Class<T> responseClass,
                           String a, String b, String c, String d) {

        HttpHeaders headers = new HttpHeaders();
        headers.add(a, b);
        headers.add(c, d);

        return webClientConfig.webClient().method(HttpMethod.GET)
                .uri(url)
                .headers(h -> h.addAll(headers))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(responseClass)
                .block();

    }
}
