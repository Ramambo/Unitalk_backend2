package com.unitalk.common.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class EmployeeDto {

    private Long empId;
    private Long loginNo;
    private String deptId;
    private String username;
    private String email;
    private String phoneNumber;
    private LocalDate registrationYear;
    private String deptDetail;

}
