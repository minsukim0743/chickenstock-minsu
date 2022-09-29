package com.chicken.project.member.model.dto;

import com.chicken.project.calendar.model.dto.CalendarDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class EmployeeDTO {

    private String empId;
    private String empName;
    private String empPhone;
    private String empEmail;
    private String empPwd;
    private java.sql.Date birth;
    private String empRole;
    private String emailCode;

    private List<EmpRoleDTO> empRoleList;

    private List<CalendarDTO> calendar;

    private int rnum;


}
