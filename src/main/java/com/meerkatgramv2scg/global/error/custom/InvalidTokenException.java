package com.meerkatgramv2scg.global.error.custom;


public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException(String message) {
        // 부모클레스(RuntimeException: 자바기본제공)의 메소드(e.message) 이용하기 위해 메세지에 우리가 받은 에러메세지 넣음
        super(message);
    }
}
