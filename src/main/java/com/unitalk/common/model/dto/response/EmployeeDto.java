package com.unitalk.common.model.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDto {

    Long employeeNo; // 교직원번호
    UserDto user;  // 직원ID
    LocalDate hireDate; // 입사일
    String deptDetail; // 교직원구분

}
