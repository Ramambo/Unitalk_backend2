package com.unitalk.emp.controller;

import com.unitalk.common.service.EmployeeService;
import com.unitalk.emp.model.dto.ProfessorAssignmentRequest;
import com.unitalk.emp.model.dto.ProfessorListItem;
import com.unitalk.emp.service.ProfessorAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assign-prof")
public class ProfessorAssignmentController {

    private final ProfessorAssignmentService professorAssignmentService;
    private final EmployeeService employeeService;

    @Autowired
    public ProfessorAssignmentController(ProfessorAssignmentService professorAssignmentService, EmployeeService employeeService) {
        this.professorAssignmentService = professorAssignmentService;
        this.employeeService = employeeService;
    }

    //교수목록 조회
    @GetMapping("/list/professors")
    public List<ProfessorListItem> getProfessors() {
        // "교수" 부서에 속하는 교직원들의 정보를 가져옵니다.
        List<ProfessorListItem> professors = employeeService.getProfessors();
        return professors;
    }

    //지도교수 배정 이력 생성
    @PostMapping("/new")
    public Long save(@RequestBody final ProfessorAssignmentRequest params) {
        return professorAssignmentService.save(params);
    }

}
