package com.chicken.project.notice.model.dto;

public class NoticeFileDTO {

    private int fileNo; // 파일번호
    private String originName; // 원본이름
    private String fileName; // 바뀐이름

    private String savedPath; // 파일 저장경로
    private int noticeNo; // 공지사항 번호

    public NoticeFileDTO() {}

    public NoticeFileDTO(int fileNo, String originName, String fileName, String savedPath, int noticeNo) {
        this.fileNo = fileNo;
        this.originName = originName;
        this.fileName = fileName;
        this.savedPath = savedPath;
        this.noticeNo = noticeNo;
    }

    public int getFileNo() {
        return fileNo;
    }

    public void setFileNo(int fileNo) {
        this.fileNo = fileNo;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSavedPath() {
        return savedPath;
    }

    public void setSavedPath(String savedPath) {
        this.savedPath = savedPath;
    }

    public int getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(int noticeNo) {
        this.noticeNo = noticeNo;
    }

    @Override
    public String toString() {
        return "NoticeFileDTO{" +
                "fileNo=" + fileNo +
                ", originName='" + originName + '\'' +
                ", fileName='" + fileName + '\'' +
                ", savedPath='" + savedPath + '\'' +
                ", noticeNo=" + noticeNo +
                '}';
    }
}
