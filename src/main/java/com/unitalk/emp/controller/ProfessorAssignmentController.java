package com.unitalk.emp.controller;

import com.unitalk.emp.model.dto.ProfessorAssignmentListItem;
import com.unitalk.emp.model.dto.ProfessorAssignmentRequest;
import com.unitalk.emp.model.dto.ProfessorListItem;
import com.unitalk.emp.model.dto.StudentListItem;
import com.unitalk.emp.service.ProfessorAssignmentService;
import com.unitalk.emp.service.ProfessorListService;
import com.unitalk.emp.service.StudentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assign-prof")
public class ProfessorAssignmentController {

    private final ProfessorAssignmentService professorAssignmentService;
    private final ProfessorListService professorListService;
    private final StudentListService studentListService;

    @Autowired
    public ProfessorAssignmentController(ProfessorAssignmentService professorAssignmentService, ProfessorListService professorListService, StudentListService studentListService) {
        this.professorAssignmentService = professorAssignmentService;
        this.professorListService = professorListService;
        this.studentListService = studentListService;
    }

    //전체 교수목록 조회
    @GetMapping("/list/professors/all")
    public List<ProfessorListItem> getAllProfessors() {
        // "교수" 부서에 속하는 교직원들의 정보를 가져옵니다.
        List<ProfessorListItem> professors = professorListService.getAllProfessors();
        return professors;
    }

    //학과별 교수목록 조회
    @GetMapping("/list/professors/{deptId}")
    public List<ProfessorListItem> getProfessorsByDeptId(@PathVariable String deptId) {
        //특정 학과에 속하는 교수들의 정보를 가져옵니다.
        return professorListService.getProfessorsByDeptId(deptId);
    }

    //전체 학생목록 조회
    @GetMapping("/list/students/all")
    public List<StudentListItem> getStudents() {
        return studentListService.getAllStudents();
    }

    //학과별 학생목록 조회
    @GetMapping("/list/students/{deptId}")
    public List<StudentListItem> getStudentsByDeptId(@PathVariable String deptId) {
        return studentListService.getStudentsByDeptId(deptId);
    }

    //전체 지도교수 배정 이력 조회
    @GetMapping("/list/assignments")
    public List<ProfessorAssignmentListItem> getAssignments() {
        return professorAssignmentService.getAllAssignments();
    }

    //지도교수 배정 이력 생성
    @PostMapping("/new")
    public Long save(@RequestBody final ProfessorAssignmentRequest params) {
        return professorAssignmentService.save(params);
    }

}
