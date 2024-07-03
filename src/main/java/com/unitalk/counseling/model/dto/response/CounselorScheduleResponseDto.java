package com.unitalk.counseling.model.dto.response;

import com.unitalk.common.model.entity.Employee;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CounselorScheduleResponseDto {

    private long schNo;
    private Employee counselor;
    private String days;
    private long availTime;
    private long status;

}
