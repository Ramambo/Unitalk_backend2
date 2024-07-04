package com.unitalk.counseling.model.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CounselorScheduleRequestDto {

    private Long counselorId;
    private String days;
    private Long availTime;
    private Long status;

}
