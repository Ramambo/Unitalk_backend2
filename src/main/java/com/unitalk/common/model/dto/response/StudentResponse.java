package com.unitalk.common.model.dto.response;

import com.unitalk.common.model.entity.Department;
import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {
    private User studentCode; // 사용자 엔티티와 매핑
    private String name; // 이름
    private Integer grade; // 학년
    private LocalDateTime admissionDate; // 입학일
    private String email; // 이메일
    private String phone; // 전화번호
    private Employee empCode; // 지도교수
    private Department deptCode; // 학과 코드
}
