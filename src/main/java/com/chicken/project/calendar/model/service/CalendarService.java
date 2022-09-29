package com.chicken.project.calendar.model.service;

import com.chicken.project.calendar.model.dto.CalendarDTO;

import java.util.List;
import java.util.Map;

public interface CalendarService {

    List<CalendarDTO> selectCalendar();

    int insertCal(CalendarDTO cal);

    int deleteCal(CalendarDTO cal);

    int updateCal(CalendarDTO cal);


    CalendarDTO selectCalNo(CalendarDTO cal);
}
