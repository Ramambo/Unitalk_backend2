package com.unitalk.emp.service;

import com.unitalk.common.model.entity.Department;
import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.User;
import com.unitalk.common.repository.DepartmentRepository;
import com.unitalk.emp.model.dto.ProfessorListItem;
import com.unitalk.emp.repository.ProfessorListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorListServiceImpl implements ProfessorListService {

    private final ProfessorListRepository professorListRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public ProfessorListServiceImpl(ProfessorListRepository professorListRepository, DepartmentRepository departmentRepository) {
        this.professorListRepository = professorListRepository;
        this.departmentRepository = departmentRepository;
    }

    //전체 교수목록 조회
    @Override
    public List<ProfessorListItem> getAllProfessors() {
        // "교수" 부서에 속하는 교직원들의 정보를 데이터베이스에서 조회합니다.
        List<Employee> employees = professorListRepository.findByDeptDetail("교수");

        // Employee 엔티티를 ProfessorListItem DTO로 변환합니다.
        List<ProfessorListItem> professors = employees.stream()
                .map(employee -> {
                    User professorUser = employee.getUser(); //Employee Entity의 employeeId는 User Entity를 참조
                    String professorDeptId = professorUser.getDeptId().getDeptName();

                    return new ProfessorListItem(
                            employee.getEmployeeNo(),
                            professorUser.getUserId(),
                            professorDeptId,
                            professorUser.getUserName(),
                            professorUser.getEmail(),
                            professorUser.getTel()
                    );
                })
                .collect(Collectors.toList());

        return professors;
    }

    //학과별 교수목록 조회
    @Override
    public List<ProfessorListItem> getProfessorsByDeptId(String deptId) {
        //deptId를 이용해서 학과 정보를 조회
        Department department = departmentRepository.findByDeptId(deptId);
        if(department == null) {
            throw new IllegalArgumentException("Invalid deptId: " + deptId);
        }
        
        //학과 이름 가져오기 세팅
        String deptName = department.getDeptName();

        //"교수"이면서 특정 학과에 속하는 교직원들의 정보를 조회합니다.
        List<Employee> employees = professorListRepository.findByDeptDetailAndUser_DeptId_DeptName("교수", deptName);

        //Employee 엔티티를 ProfessorListItem DTO로 변환합니다.
        return employees.stream()
                .map(employee -> {
                    User professorUser = employee.getUser(); // Employee Entity의 employeeId는 User Entity를 참조
                    String professorDeptName = professorUser.getDeptId().getDeptName();

                    return new ProfessorListItem(
                            employee.getEmployeeNo(),
                            professorUser.getUserId(),
                            professorDeptName,
                            professorUser.getUserName(),
                            professorUser.getEmail(),
                            professorUser.getTel()
                    );
                })
                .collect(Collectors.toList());
    }

}
