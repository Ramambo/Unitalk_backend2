package com.unitalk.emp.service;

import com.unitalk.common.model.entity.ProfessorAssignment;
import com.unitalk.emp.model.dto.ProfessorAssignmentRequest;
import com.unitalk.emp.repository.ProfessorAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorAssignmentServiceImpl implements ProfessorAssignmentService {

    private final ProfessorAssignmentRepository professorAssignmentRepository;

    @Autowired
    public ProfessorAssignmentServiceImpl(ProfessorAssignmentRepository professorAssignmentRepository) {
        this.professorAssignmentRepository = professorAssignmentRepository;
    }

    //지도교수 배정 이력 생성
    @Override
    public Long save(ProfessorAssignmentRequest params) {
        ProfessorAssignment professorAssignment = params.toEntity();
        professorAssignmentRepository.save(professorAssignment);
        return (long) professorAssignment.getAssignmentId();
    }

}