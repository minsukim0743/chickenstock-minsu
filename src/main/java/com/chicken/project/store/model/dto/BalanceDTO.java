package com.chicken.project.store.model.dto;

import com.chicken.project.account.model.dto.AccountDTO;

public class BalanceDTO {

    private String storeName; // 가맹점 명
    private int balance; // 잔액
    private AccountDTO accountDTO;

    public BalanceDTO() {}

    public BalanceDTO(String storeName, int balance, AccountDTO accountDTO) {
        this.storeName = storeName;
        this.balance = balance;
        this.accountDTO = accountDTO;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public AccountDTO getAccountDTO() {
        return accountDTO;
    }

    public void setAccountDTO(AccountDTO accountDTO) {
        this.accountDTO = accountDTO;
    }

    @Override
    public String toString() {
        return "BalanceDTO{" +
                "storeName='" + storeName + '\'' +
                ", balance=" + balance +
                ", accountDTO=" + accountDTO +
                '}';
    }
}
