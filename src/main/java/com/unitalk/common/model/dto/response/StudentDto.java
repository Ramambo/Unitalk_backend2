package com.unitalk.common.model.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDto {

    Long studentNo;
    UserDto user;
    LocalDate regDate;
    Long grade;
    EmployeeDto professor;

}
