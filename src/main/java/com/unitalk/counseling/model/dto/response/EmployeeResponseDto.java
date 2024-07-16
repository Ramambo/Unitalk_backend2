package com.unitalk.counseling.model.dto.response;

import com.unitalk.common.model.entity.User;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDto {
    private Long employeeNo;
    private User user;
    private String deptDetail;
}