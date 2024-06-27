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
@Table(name = "CommonCode")
public class CommonCode {
    @Id
    @Column(nullable = false)
    private String division; // 코드 대분류

    @Column(nullable = false)
    private String code; // 분류 코드(PK)

    @Column(nullable = false)
    private String codeName; // 분류 코드명
}
