package com.unitalk.counseling.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter @Setter
@ToString
public class CounselingCreateRequest {
    private Long empId;
    private Long studentId;
    private Long schNo;
    private Long counselMode;
    private String applicationContent;
    private String status;
    private String counselContent;
    private String counselDate;


}
