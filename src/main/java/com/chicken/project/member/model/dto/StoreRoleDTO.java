package com.chicken.project.member.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class StoreRoleDTO {

    private String authCode;
    private String storeName;
    private String storeId;

    private AuthDTO authority;
}
