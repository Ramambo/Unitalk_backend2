package com.unitalk.counseling.dto.response;

import com.unitalk.counseling.model.entity.Counseling;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CounselingResponse {

    private Long reqNo; //상담 신청 번호 
    private Long studentId; // 학생ID
    private Long empId; // 상담사ID(교수)
    private Long schNo; // 시간표 번호 
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime applicationDate; //신청일시
    private LocalDateTime recordTime; // 신청시간코드
    private Long counselMode; // 상담유형
    //private String counselType;
    private String applicationContent; //신청내용
    private Long status; // 진행상태
    private String counselContent; // 상담내용
    private LocalDateTime counselDate; // 상담일시
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
