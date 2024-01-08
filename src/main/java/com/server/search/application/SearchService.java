package com.server.search.application;

import com.server.search.external.ExternalInterface;
import com.server.search.external.naver.NaverSearchApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final ExternalInterface externalInterface;
    public void search(String query, String sort) {
        externalInterface.search(query, sort);
    }
    /*

     */
    public void set() {

    }
}
