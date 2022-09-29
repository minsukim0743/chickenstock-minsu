package com.chicken.project.calendar.model.service;

import com.chicken.project.calendar.model.dto.CalendarDTO;
import com.chicken.project.member.model.dao.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {


    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final EmployeeMapper employeeMapper;

    @Autowired
    public CalendarServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    /* 일정 조회 */
    @Override
    public List<CalendarDTO> selectCalendar() {

        List<CalendarDTO>  calList = employeeMapper.selectCalendar();

        return calList;
    }

    /* 일정 추가 */
    @Override
    @Transactional
    public int insertCal(CalendarDTO cal) {

        int result = employeeMapper.insertCalendar(cal);

        log.info("[CalendarService] result : " + result);

        return result;
    }

    @Override
    public int deleteCal(CalendarDTO cal) {

        int result = employeeMapper.deleteCal(cal);

        return result;
    }

    @Override
    public int updateCal(CalendarDTO cal) {

        int result1 = employeeMapper.updateCal(cal);

        return result1;
    }

    @Override
    public CalendarDTO selectCalNo(CalendarDTO cal) {

        CalendarDTO calendar = employeeMapper.selectCalNo(cal);

        return calendar;
    }
}
