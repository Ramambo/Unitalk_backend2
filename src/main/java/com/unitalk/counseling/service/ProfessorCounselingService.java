package com.unitalk.counseling.service;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.repository.EmployeeRepository;
import com.unitalk.counseling.model.dto.response.EmployeeResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // final이 붙인 생성자 argu를 던져주는 어노테이션
public class ProfessorCounselingService {

    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<EmployeeResponseDto> getCounselorFindAll() {
        List<Employee> list = employeeRepository.findAll();
        return list.stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponseDto.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<EmployeeResponseDto> getProfessorsByCounselType(String deptDetail){
        List<Employee> list = employeeRepository.findByDeptDetail(deptDetail);
        return list.stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponseDto.class))
                .collect(Collectors.toList());
    }

}