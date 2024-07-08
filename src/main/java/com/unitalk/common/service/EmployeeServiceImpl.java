package com.unitalk.common.service;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.User;
import com.unitalk.emp.model.dto.ProfessorListItem;
import com.unitalk.common.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //전체 교수목록 조회
    @Override
    public List<ProfessorListItem> getProfessors() {
        // "교수" 부서에 속하는 교직원들의 정보를 데이터베이스에서 조회합니다.
        List<Employee> employees = employeeRepository.findByDeptDetail("교수");

        // Employee 엔티티를 ProfessorListItem DTO로 변환합니다.
        List<ProfessorListItem> professors = employees.stream()
                .map(employee -> {
                    User professorUser = employee.getUser(); //Employee Entity의 employeeId는 User Entity를 참조
                    String professorDeptId = professorUser.getDeptId().getDeptName();

                    return new ProfessorListItem(
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
}
