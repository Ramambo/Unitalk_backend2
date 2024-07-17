package com.unitalk.counseling.model.dto.response;

import com.unitalk.common.model.dto.response.DepartmentDto;
import com.unitalk.common.model.dto.response.EmployeeDto;
import com.unitalk.common.model.dto.response.StudentDto;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CounselingResponseDto {

    private Long reqNo;
    private StudentDto student;
    private EmployeeDto counselor;
    private LocalDate counselDate;
    private CounselorScheduleResponseDto schedule;
    private LocalDateTime applicationDate;
    private Long counselMode;
    private DepartmentDto department;
    private String applicationContent;
    private Long status;
    private String counselContent;
    private LocalDateTime recordTime;

}