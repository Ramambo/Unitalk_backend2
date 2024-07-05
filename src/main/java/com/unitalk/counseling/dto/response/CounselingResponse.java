package com.unitalk.counseling.dto.response;

import com.unitalk.counseling.model.entity.Counseling;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CounselingResponse {

    private Long reqNo;
    private Long studentId;
    private Long empId;
    private Long schNo;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime applicationDate;
    private LocalDateTime recordTime;
    private Long counselMode;
    //private String counselType;
    private String applicationContent;
    private Long status;
    private String counselContent;
    private LocalDateTime counselDate;
    //private Counseling previousReqNo;

    public static CounselingResponse from(Counseling counseling) {
        return new CounselingResponse(
                counseling.getReqNo(),
                counseling.getEmployee().getEmpId(),
                counseling.getCounselorSchedule().getSchNo(),
                counseling.getStudent().getStudentId(),
                counseling.getApplicationDate(),
                counseling.getRecordTime(),
                counseling.getCounselMode(),
                counseling.getApplicationContent(),
                counseling.getStatus(),
                counseling.getCounselContent(),
                counseling.getCounselDate()
        );
    }


}
