package com.unitalk.emp.service;

import com.unitalk.emp.model.dto.ProfessorAssignmentListItem;
import com.unitalk.emp.model.dto.ProfessorAssignmentRequest;

import java.util.List;

public interface ProfessorAssignmentService {

    //지도교수 배정 이력 조회
    List<ProfessorAssignmentListItem> getAllAssignments();

    //지도교수 배정 이력 생성
    Long save(ProfessorAssignmentRequest params);

}
