package com.unitalk.common.repository;

import com.unitalk.common.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // "교수" 부서에 속하는 직원들을 deptDetail로 조회합니다.
    List<Employee> findByDeptDetail(String deptDetail);
}