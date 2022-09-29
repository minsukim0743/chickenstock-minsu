package com.chicken.project.counsel.model.dto;

import java.sql.Date;

public class CounselApplyDTO {

    private int counselNo;
    private String answerContent;
    private Date answerRegistDate;
    private String empName;

    public CounselApplyDTO() {}

    public CounselApplyDTO(int counselNo, String answerContent, Date answerRegistDate, String empName) {
        this.counselNo = counselNo;
        this.answerContent = answerContent;
        this.answerRegistDate = answerRegistDate;
        this.empName = empName;
    }

    public int getCounselNo() {
        return counselNo;
    }

    public void setCounselNo(int counselNo) {
        this.counselNo = counselNo;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Date getAnswerRegistDate() {
        return answerRegistDate;
    }

    public void setAnswerRegistDate(Date answerRegistDate) {
        this.answerRegistDate = answerRegistDate;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "CounselApplyDTO{" +
                "counselNo=" + counselNo +
                ", answerContent='" + answerContent + '\'' +
                ", answerRegistDate=" + answerRegistDate +
                ", empName='" + empName + '\'' +
                '}';
    }
}
