package com.unitalk.common.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DepartmentDto {

    private String deptId;
    private String deptName;

}
