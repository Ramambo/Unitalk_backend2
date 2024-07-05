package com.unitalk.common.exception;

import lombok.Getter;

@Getter
public class ConflictException extends CustomException {

    public ConflictException(final ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
