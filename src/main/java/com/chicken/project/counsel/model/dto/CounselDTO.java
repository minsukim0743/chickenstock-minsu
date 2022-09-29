package com.chicken.project.counsel.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CounselDTO {

    private int counselNo;
    private String counselName;
    private String counselContent;
    private Date counselRegistDate;
    private String storeName;
    private String counselYn;

}
