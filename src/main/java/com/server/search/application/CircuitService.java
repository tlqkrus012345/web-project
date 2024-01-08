package com.server.search.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
/*
접속 성공과 실패 이벤트가 발생할 때마다 내부 상태를 업데이트하여 자동적으로 장애를 검출하고 복구 여부를 판단
네이버 open() -> 실패율이 정해 놓은 임계치를 넘으면 closed() -> 카카오 open()
일정 시간이 지나면 네이버 halfOpen() -> 네이버 요청 성공하면 네이버 open, 카카오 closed()
 */
public class CircuitService {

}
