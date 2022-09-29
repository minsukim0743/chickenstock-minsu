package com.chicken.project.account.model.dto;

import java.sql.Date;

public class AccountDTO {

    private String storeName; // 가맹점명
    private int depositNum; // 입금신청번호
    private Date accountDate; // 입금신청일
    private int accountDeposit; // 입금액
    private String accountYn; // 입금신청여부

    public AccountDTO() {}

    public AccountDTO(String storeName, int depositNum, Date accountDate, int accountDeposit, String accountYn) {
        this.storeName = storeName;
        this.depositNum = depositNum;
        this.accountDate = accountDate;
        this.accountDeposit = accountDeposit;
        this.accountYn = accountYn;
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

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public int getAccountDeposit() {
        return accountDeposit;
    }

    public void setAccountDeposit(int accountDeposit) {
        this.accountDeposit = accountDeposit;
    }

    public String getAccountYn() {
        return accountYn;
    }

    public void setAccountYn(String accountYn) {
        this.accountYn = accountYn;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "storeName='" + storeName + '\'' +
                ", depositNum=" + depositNum +
                ", accountDate=" + accountDate +
                ", accountDeposit=" + accountDeposit +
                ", accountYn='" + accountYn + '\'' +
                '}';
    }
}
