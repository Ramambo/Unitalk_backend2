package com.unitalk.common.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CommonCode")
@Getter
@NoArgsConstructor
public class CommonCode {

    @Id
    @Column(name = "division", nullable = false)
    private String division; //코드 대분류

    @Id
    @Column(name = "code", unique = true, nullable = false)
    private String code; //분류 코드, PK

    @Column(name = "code_name", nullable = false)
    private String codeName; //분류 코드명

    @Builder
    public CommonCode(String division, String code, String codeName) {
        this.division = division;
        this.code = code;
        this.codeName = codeName;
    }
}
