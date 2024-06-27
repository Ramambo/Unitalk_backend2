package com.unitalk.common.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@IdClass(CommonCode.CommonCodeId.class) // 복합키 정의
@Table(name = "CommonCode")
public class CommonCode {

    @Id
    @Column(name = "division", nullable = false)
    private String division; // 코드 대분류

    @Id
    @Column(name = "code", unique = true, nullable = false)
    private String code; // 분류 코드, PK

    @Column(name = "code_name", nullable = false)
    private String codeName; // 분류 코드명

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @EqualsAndHashCode // equals()와 hashCode() 메서드를 자동으로 생성
    public static class CommonCodeId implements Serializable { //복합키 사용을 위한 설절
        private String division;
        private String code;
    }
}
