package com.server.search.presentation;

import com.server.search.application.CircuitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SearchController {
    // 요청 -> 컨트롤러 -> 서킷 서비스-> 서치 서비스-> 외부 api 호출
    private final CircuitService circuitService;
    @GetMapping("/search")
    public void search(@RequestParam("food") String food, @RequestParam("sort") String sort) {

    }
}
