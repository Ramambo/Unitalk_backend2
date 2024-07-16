package com.unitalk.common.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    Long userId;
    DepartmentDto department;
    String userName;
    String tel;
    String email;
    String userType;

}
