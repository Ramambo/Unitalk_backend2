package com.unitalk.common.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class EmployeeDto {

    private Integer empId;
    private Integer loginNo;
    private String deptId;
    private String username;
    private String email;
    private String phoneNumber;
    private Timestamp registrationYear;
    private String deptDetail;

}
