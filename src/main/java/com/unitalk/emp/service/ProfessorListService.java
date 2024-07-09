package com.unitalk.emp.service;

import com.unitalk.emp.model.dto.ProfessorListItem;

import java.util.List;

public interface ProfessorListService {
    //전체 교수목록 조회
    List<ProfessorListItem> getAllProfessors();

    //학과별 교수목록 조회
    List<ProfessorListItem> getProfessorsByDeptId(String deptId);
    
}