package com.unitalk.counseling.model.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CounselorScheduleRequestDto {

    private Integer counselorId;
    private String days;
    private long availTime;
    private long status;

}
