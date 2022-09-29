package com.chicken.project.member.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class StoreMemberDTO{

    private String storeName;
    private String storeAccount;
    private String storeRep;
    private String storeAddress;
    private String storePhone;
    private String storeEmail;
    private String storeId;
    private String storePwd;
    private String storeNo;
    private String storeYn;


    private List<StoreRoleDTO> storeRoleList;

}
