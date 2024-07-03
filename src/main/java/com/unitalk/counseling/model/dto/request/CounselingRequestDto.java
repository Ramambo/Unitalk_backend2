package com.unitalk.counseling.model.dto.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CounselingRequestDto {

    private Integer studentId;
    private Integer counselorId;
    private LocalDate counselDate;
    private long schNo;
    private long counselMode;
    private String counselType;
    private String applicationContent;

}