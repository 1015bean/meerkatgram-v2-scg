package com.meerkatgramv2scg.global.error;

import com.meerkatgramv2scg.global.response.GlobalRes;
import com.meerkatgramv2scg.global.response.constant.CustomResponseCode;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;
import tools.jackson.databind.ObjectMapper;

// 예외처리 커스텀
// WebExceptionHandler: Spring WebFlux에서 전역 예외 처리를 직접 구현할 때 사용하는 인터페이스
@Component
@RequiredArgsConstructor
@Order(-2)  // spring의 기본 예외처리기 ErrorWebExceptionHandler(-1)보다 먼저 실행시킴(-2)
public class GlobalErrorWebExceptionHandler implements WebExceptionHandler {

    private final ObjectMapper objectMapper;

    // Mono: Spring WebFlux(Reactor)에서 사용하는 '비동기' 데이터 컨테이너
        // Mono<T>는 0개 혹은 1개의 데이터를 가짐
    // exchange : 현재 HTTP 요청과 응답을 담고 있는 객체
    // ex : 발생한 예외 객체
    @Override
    @NonNull
    public Mono<Void> handle(@NonNull ServerWebExchange exchange, @NonNull Throwable ex) {

        // exchange에서 res 추출
        ServerHttpResponse response = exchange.getResponse();

        // 커스텀 에러 코드
        CustomResponseCode customResponseCode = (
                ex instanceof ResponseStatusException res
                        && res.getStatusCode().value() == 404)
                ? CustomResponseCode.NOT_FOUND_ERROR
                : CustomResponseCode.SYSTEM_ERROR;

        response.setStatusCode((customResponseCode.getHttpStatus()));  // Http Status 변경
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);  // Contents-Type를 JSON으로 변경

        byte[] bytes = objectMapper.writeValueAsBytes(GlobalRes.from(customResponseCode)); // byte 형태로 변환
        return response.writeWith(Mono.just(response.bufferFactory().wrap(bytes)));
    }
}
