package com.chicken.project.notice.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;


public class NoticeDTO {
    
    private int noticeNo; // 공지사항 번호
    private String noticeName; // 공지사항 제목
    private String noticeContent; // 공지사항 내용
    private String noticeRegistDate; // 공지사항 등록일
    private String noticeModifyDate; // 공지사항 수정일
    private String empName; // 등록자 이름
    private int noticeCount; // 조회수
    private NoticeFileDTO noticeFile; // 공지사항 파일

    public NoticeDTO() {}

    public NoticeDTO(int noticeNo, String noticeName, String noticeContent, String noticeRegistDate, String noticeModifyDate, String empName, int noticeCount, NoticeFileDTO noticeFile) {
        this.noticeNo = noticeNo;
        this.noticeName = noticeName;
        this.noticeContent = noticeContent;
        this.noticeRegistDate = noticeRegistDate;
        this.noticeModifyDate = noticeModifyDate;
        this.empName = empName;
        this.noticeCount = noticeCount;
        this.noticeFile = noticeFile;
    }

    public int getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(int noticeNo) {
        this.noticeNo = noticeNo;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeRegistDate() {
        return noticeRegistDate;
    }

    public void setNoticeRegistDate(String noticeRegistDate) {
        this.noticeRegistDate = noticeRegistDate;
    }

    public String getNoticeModifyDate() {
        return noticeModifyDate;
    }

    public void setNoticeModifyDate(String noticeModifyDate) {
        this.noticeModifyDate = noticeModifyDate;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getNoticeCount() {
        return noticeCount;
    }

    public void setNoticeCount(int noticeCount) {
        this.noticeCount = noticeCount;
    }

    public NoticeFileDTO getNoticeFile() {
        return noticeFile;
    }

    public void setNoticeFile(NoticeFileDTO noticeFile) {
        this.noticeFile = noticeFile;
    }

    @Override
    public String toString() {
        return "NoticeDTO{" +
                "noticeNo=" + noticeNo +
                ", noticeName='" + noticeName + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeRegistDate='" + noticeRegistDate + '\'' +
                ", noticeModifyDate='" + noticeModifyDate + '\'' +
                ", empName='" + empName + '\'' +
                ", noticeCount=" + noticeCount +
                ", noticeFile=" + noticeFile +
                '}';
    }
}


