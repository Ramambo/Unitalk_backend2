package com.unitalk.common.model.dto.request;

import com.unitalk.common.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String userCode; //사용자 코드, 학번 및 교번
    private String password; //사용자 암호
    private Integer userType; //사용자 구분

    // DTO 객체를 엔티티로 변환
    public User toEntity() {
        return User.builder()
                .userCode(userCode)
                .password(password)
                .userType(userType)
                .build();
    }
}
