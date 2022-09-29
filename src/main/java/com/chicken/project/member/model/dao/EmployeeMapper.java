package com.chicken.project.member.model.dao;

import com.chicken.project.calendar.model.dto.CalendarDTO;
import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.member.model.dto.EmployeeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<EmployeeDTO> selectAllEmployee(SelectCriteria selectCriteria);
    int insertEmployee(EmployeeDTO emp);
    int insertEmpRole(EmployeeDTO emp);
    EmployeeDTO selectEmpInfo(String empId);
    int selectCkAdminAuth(String empId);
    int insertAuth(String empId);
    List<CalendarDTO> selectCalendar();
    int insertCalendar(CalendarDTO cal);
    int deleteCal(CalendarDTO cal);
    int updateCal(CalendarDTO cal);
    CalendarDTO selectCalNo(CalendarDTO cal);
    int updateEmpPwd(EmployeeDTO emp);

    int updateEmailCode(EmployeeDTO emp);

    int selectTotalCount();

    EmployeeDTO selectEmailCode(EmployeeDTO emp);

    int updatePwd(EmployeeDTO emp);
}
