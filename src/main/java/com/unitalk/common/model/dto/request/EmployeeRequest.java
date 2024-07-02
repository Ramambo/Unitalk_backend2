package com.unitalk.common.model.dto.request;

import com.unitalk.common.model.entity.Department;
import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    private User empCode;
    private String name; // 이름
    private LocalDate hireDate; // 입사일
    private String email; // 이메일
    private String phone; // 전화번호
    private Department deptCode; // 부서 코드
    private String deptDetail; // 교직원 구분

    // DTO 객체를 엔티티로 변환
    public Employee toEntity() {
        return Employee.builder()
                .empCode(empCode)
                .name(name)
                .hireDate(hireDate)
                .email(email)
                .phone(phone)
                .deptCode(deptCode)
                .deptDetail(deptDetail)
                .build();
    }
}
