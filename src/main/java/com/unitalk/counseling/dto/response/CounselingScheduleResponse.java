package com.unitalk.counseling.dto.response;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.counseling.model.entity.CounselorSchedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CounselingScheduleResponse {

    private Long schNo; // 시간표 번호
    private Employee empId; // 교직원 ID
    private String days; // 상담요일
    private Long availTime; // 시간코드
    private Long status; // 상태 (활성화1 / 비활성화 2)

    public static CounselingScheduleResponse from(CounselorSchedule counselorSchedule){
        return new CounselingScheduleResponse(
                counselorSchedule.getSchNo(),
                counselorSchedule.getEmpId(),
                counselorSchedule.getDays(),
                counselorSchedule.getAvailTime(),
                counselorSchedule.getStatus()
        );
    }


}
