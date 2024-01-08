package com.server.search.presentation;

import com.server.search.application.CircuitService;
import com.server.search.application.SearchFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SearchController {
    // 요청 -> 컨트롤러 -> 서킷 서비스-> 서치 서비스-> 외부 api 호출
    private final SearchFacade searchFacade;
    @GetMapping("/search")
    public void search(@RequestParam("query") String query, @RequestParam("sort") String sort) {
        searchFacade.search(query, sort);
    }
}
