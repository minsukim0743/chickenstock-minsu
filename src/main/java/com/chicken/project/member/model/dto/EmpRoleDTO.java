package com.chicken.project.member.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class EmpRoleDTO {

    private String authCode;
    private String empId;

    private AuthDTO authority;
}
