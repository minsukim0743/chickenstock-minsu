package com.chicken.project.account.model.dto;

import java.sql.Date;

public class AccountApplyDTO {

    private String storeName; // 가맹점명
    private int depositNum; // 입금신청번호
    private Date depositRegistDate; // 입금신청일
    private AccountDTO accountDTO; // 입금액
    private String depositYn; // 입금상태여부

    public AccountApplyDTO() {}

    public AccountApplyDTO(String storeName, int depositNum, Date depositRegistDate, AccountDTO accountDTO, String depositYn) {
        this.storeName = storeName;
        this.depositNum = depositNum;
        this.depositRegistDate = depositRegistDate;
        this.accountDTO = accountDTO;
        this.depositYn = depositYn;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getDepositNum() {
        return depositNum;
    }

    public void setDepositNum(int depositNum) {
        this.depositNum = depositNum;
    }

    public Date getDepositRegistDate() {
        return depositRegistDate;
    }

    public void setDepositRegistDate(Date depositRegistDate) {
        this.depositRegistDate = depositRegistDate;
    }

    public AccountDTO getAccountDTO() {
        return accountDTO;
    }

    public void setAccountDTO(AccountDTO accountDTO) {
        this.accountDTO = accountDTO;
    }

    public String getDepositYn() {
        return depositYn;
    }

    public void setDepositYn(String depositYn) {
        this.depositYn = depositYn;
    }

    @Override
    public String toString() {
        return "AccountApplyDTO{" +
                "storeName='" + storeName + '\'' +
                ", depositNum=" + depositNum +
                ", depositRegistDate=" + depositRegistDate +
                ", accountDTO=" + accountDTO +
                ", depositYn='" + depositYn + '\'' +
                '}';
    }
}
