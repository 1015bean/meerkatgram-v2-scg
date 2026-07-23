package com.meerkatgramv2scg.global.error.custom;

// NotRegisteredException:
    // 일반 Exception과 달리 try-catch문 작성할 필요 없음(언체크 예외) -> 코드 간략화
    // RuntimeException 발생 시 "심각한 문제가 생겼구나!" 하고 변경사항을 자동으로 롤백함
public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String message) {
        super(message);
    }
}
