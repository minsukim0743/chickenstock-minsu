package com.chicken.project.calendar.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CalendarDTO {

    private int calNo;
    private String calName;
    private java.sql.Date startDay;
    private java.sql.Date endDay;
    private String content;
    private String empId;
    private String edit;

}