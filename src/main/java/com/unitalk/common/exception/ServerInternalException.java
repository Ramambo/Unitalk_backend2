package com.unitalk.common.exception;

public class ServerInternalException extends CustomException {

    public ServerInternalException(final ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
