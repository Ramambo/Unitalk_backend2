package com.unitalk.counseling.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class CounselingUpdateRequest {
    private long reqNo;
    private byte counselMode;
    private String applicationContent;
    private byte status;
    private String counselContent;
    private LocalDateTime counselDate;
}
