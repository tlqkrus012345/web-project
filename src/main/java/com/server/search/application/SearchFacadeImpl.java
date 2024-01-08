package com.server.search.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchFacadeImpl implements SearchFacade{
    private final CircuitService circuitService;
    private final SearchService searchService;

    @Override
    public String search(String query, String sort) {
        /*
        서킷 서비스를 통해 네이버 open, closed, halfOpen 상태 체크
        네이버 open 이면 네이버 api 호출 만약 closed 이면 카카오 api 호출
        일정 시간이 지나면 네이버 다시 호출

        검색 요청이
         */
        /*
        ExternalInterface 를 3개 클래스가 구현했으면 서킷 서비스를 통해 어떻게 갈아 끼울 것인가
        */

        circuitService.checkExternalApi();

        searchService.search(query, sort);

        return null;
    }
}
