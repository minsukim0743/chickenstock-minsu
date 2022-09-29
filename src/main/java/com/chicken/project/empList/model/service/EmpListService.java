package com.chicken.project.empList.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.member.model.dto.EmployeeDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmpListService {
    /* 직원 정보 리스트 조회 */
    List<EmployeeDTO> selectAllEmployee(SelectCriteria selectCriteria);

    /* 직원 정보 등록 */
    int registEmp(EmployeeDTO emp);

    int selectCkAdminAuth(String empId);

    @Transactional
    int insertAuth(String empId);

    int selectTotalCount();
}
