package com.meerkatgramv2scg.global.response.constant;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CustomResponseCode {
    SUCCESS(HttpStatus.OK, "E00")
    , NOT_REGISTERED_ERROR(HttpStatus.UNAUTHORIZED, "E01")
    , UNAUTHENTICATED_ERROR(HttpStatus.UNAUTHORIZED, "E02")
    , UNAUTHORIZED_ERROR(HttpStatus.FORBIDDEN, "E03")
    , INVALID_TOKEN_ERROR(HttpStatus.UNAUTHORIZED, "E04")
    , NOT_FOUND_DATA_ERROR(HttpStatus.NOT_FOUND, "E10")
    , DUPLICATED_DATA_ERROR(HttpStatus.CONFLICT, "E11")
    , INVALID_PARAMETER_ERROR(HttpStatus.BAD_REQUEST, "E21")
    , FILE_MANEGED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E40")
    , NOT_FOUND_ERROR(HttpStatus.NOT_FOUND, "E50")
    , DB_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E80")
    , SYSTEM_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E99")
    ;

    private final HttpStatus httpStatus;
    private final String code;

    CustomResponseCode(HttpStatus httpStatus, String code) {
        this.httpStatus = httpStatus;
        this.code = code;
    }
}
