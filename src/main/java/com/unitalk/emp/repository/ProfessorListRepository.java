package com.unitalk.emp.repository;

import com.unitalk.common.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorListRepository extends JpaRepository<Employee, Long> {
    //"교수"부서에 속하는 직원들을 deptDetail로 조회합니다.
    List<Employee> findByDeptDetail(String deptDetail);

    //학과별 교수목록 조회
    List<Employee> findByDeptDetailAndUser_DeptId_DeptName(String deptDetail, String deptId);

}