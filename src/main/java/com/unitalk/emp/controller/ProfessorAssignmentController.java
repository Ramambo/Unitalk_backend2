package com.unitalk.emp.controller;

import com.unitalk.emp.model.dto.ProfessorAssignmentRequest;
import com.unitalk.emp.service.ProfessorAssignmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProfessorAssignmentController {

    private final ProfessorAssignmentService professorAssignmentService;

    public ProfessorAssignmentController(ProfessorAssignmentService professorAssignmentService) {
        this.professorAssignmentService = professorAssignmentService;
    }

    //지도교수 배정 이력 생성
    @PostMapping("/assign-prof/new")
    public Long save(@RequestBody final ProfessorAssignmentRequest params) {
        return professorAssignmentService.save(params);
    }

}
