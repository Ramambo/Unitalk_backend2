package com.unitalk.emp.service;

import com.unitalk.emp.model.dto.ProfessorListItem;

import java.util.List;

public interface ProfessorListService {
    //교수목록 조회
    List<ProfessorListItem> getProfessors();
    
}