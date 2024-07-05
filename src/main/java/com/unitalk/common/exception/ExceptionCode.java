package com.unitalk.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionCode {

    NO_DATA(1000, "등록된 내용이 없습니다."),

    SAVE_FAIL(1003, "등록 실패 "),

    FAIL_TO_UPLOAD_FILE(1001, "파일 저장에 실패하였습니다."),
    FAIL_TO_DELETE_FILE(1002, "파일 삭제에 실패하였습니다."),

    FAIL_LOGIN(4000, "로그인에 실패하였습니다."),
    UNAUTHORIZED(4001, "인증 되지 않은 요청입니다."),
    NOT_FOUND_MEMBER_ID(4002,"아이디에 해당하는 유저가 없습니다."),
    ACCESS_DENIED(4003, "허가 되지 않은 요청입니다."),
    NOT_FOUND_MEMBER_CODE(4004, "멤버 코드에 해당하는 유저가 없습니다.");

    private final int code;
    private final String message;
}