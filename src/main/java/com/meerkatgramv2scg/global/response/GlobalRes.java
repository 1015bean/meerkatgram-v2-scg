package com.meerkatgramv2scg.global.response;

import com.meerkatgramv2scg.global.response.constant.CustomResponseCode;

// 3유저에게 return할 형식을 지정: 레스폰스 객체
public record GlobalRes<T>(
        String code
        , String message
        , T data
) {
    // data가 있는 error
    public static <T> GlobalRes<T> from(CustomResponseCode customResponseCode, T data) {
        return new GlobalRes<T>(customResponseCode.getCode(), customResponseCode.name(), data);
    }

    // data가 없는(null) error
    public static GlobalRes<Void> from(CustomResponseCode customResponseCode) {
        return new GlobalRes<Void>(customResponseCode.getCode(), customResponseCode.name(), null);
    }

    // data가 있는 success
    public static <T> GlobalRes<T> success(T data) {
        return GlobalRes.<T>from(CustomResponseCode.SUCCESS, data);
    }

    // data가 없는 success
    public static GlobalRes<Void> success() {
        return GlobalRes.<Void>from(CustomResponseCode.SUCCESS);
    }

//    public static ResponseEntity<GlobalRes<Void>> success() {
//        return ResponseEntity.ok(new GlobalRes<Void>(CustomResponseCode.SUCCESS.getCode(), CustomResponseCode.SUCCESS.name(), null));
//    }
}
