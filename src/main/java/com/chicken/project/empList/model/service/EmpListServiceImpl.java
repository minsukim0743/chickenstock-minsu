package com.chicken.project.empList.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.member.model.dao.EmployeeMapper;
import com.chicken.project.member.model.dto.EmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("empListService")
public class EmpListServiceImpl implements EmpListService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmpListServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    /* 직원 정보 리스트 조회 */
    @Override
    public List<EmployeeDTO> selectAllEmployee(SelectCriteria selectCriteria) {

        List<EmployeeDTO> empList = employeeMapper.selectAllEmployee(selectCriteria);

        return empList;
    }

    /* 직원 정보 등록 */
    @Override
    @Transactional
    public int registEmp(EmployeeDTO emp)  {

        log.info("[EmpListService] Insert Employee : " + emp);

        /* 직원 정보 추가 */
        int result1 = employeeMapper.insertEmployee(emp);

        /* 직원 권한 추가 */
        int result2 = employeeMapper.insertEmpRole(emp);

        int result = 0;

        if(result1 > 0 && result2 > 0){

            result = 1;
        }

        log.info("[EmpListService] Insert result : " + ((result > 0)? "직원 정보 추가 성공" : "직원 정보 추가 실패"));

        return result;
    }

    /* 관리자 권한 추가 */
    @Override
    public int selectCkAdminAuth(String empId) {

        int ckAdmin = employeeMapper.selectCkAdminAuth(empId);

        log.info("[EmpListService] ckAdmin : " + ckAdmin);

        return ckAdmin;
    }

    @Override
    @Transactional
    public int insertAuth(String empId) {

        log.info("[EmpListService] insertAuth : " + empId);

        int result = employeeMapper.insertAuth(empId);

        log.info("[EmpListService] insertAuth : " + result);

        return result;
    }

    @Override
    public int selectTotalCount() {

        int result = employeeMapper.selectTotalCount();

        return result;
    }
}
