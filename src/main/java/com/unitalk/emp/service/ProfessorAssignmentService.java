package com.unitalk.emp.service;

import com.unitalk.emp.model.dto.ProfessorAssignmentRequest;

public interface ProfessorAssignmentService {

    //지도교수 배정 이력 생성
    Long save(ProfessorAssignmentRequest params);

}
