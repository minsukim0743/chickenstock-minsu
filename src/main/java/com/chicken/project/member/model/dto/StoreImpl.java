package com.chicken.project.member.model.dto;

import com.chicken.project.calendar.model.dto.CalendarDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class StoreImpl extends User {
    private String storeName;
    private String storeAccount;
    private String storeRep;
    private String storeAddress;
    private String storePhone;
    private String storeEmail;
    private String storeId;
    private String storePwd;
    private String storeNo;

    private List<StoreRoleDTO> storeRoleList;

    public StoreImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public void setDetails(StoreMemberDTO member) {
        this.storeName = member.getStoreName();
        this.storeAccount = member.getStoreAccount();
        this.storeRep = member.getStoreRep();
        this.storeAddress = member.getStoreAddress();
        this.storePhone = member.getStorePhone();
        this.storeEmail = member.getStoreEmail();
        this.storeId = member.getStoreId();
        this.storePwd = member.getStorePwd();
        this.storeNo = member.getStoreNo();
        this.storeRoleList = member.getStoreRoleList();
    }


    public String getStoreName() {
        return storeName;
    }

    public String getStoreAccount() {
        return storeAccount;
    }

    public String getStoreRep() {
        return storeRep;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getStorePwd() {
        return storePwd;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public List<StoreRoleDTO> getStoreRoleList() {
        return storeRoleList;
    }

    @Override
    public String toString() {
        return "StoreImpl{" +
                "storeName='" + storeName + '\'' +
                ", storeAccount='" + storeAccount + '\'' +
                ", storeRep='" + storeRep + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storePhone='" + storePhone + '\'' +
                ", storeEmail='" + storeEmail + '\'' +
                ", storeId='" + storeId + '\'' +
                ", storePwd='" + storePwd + '\'' +
                ", storeNo='" + storeNo + '\'' +
                ", storeRoleList=" + storeRoleList +
                '}';
    }
}