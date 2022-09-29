package com.chicken.project.mypage.service;

import com.chicken.project.member.model.dto.EmployeeDTO;
import com.chicken.project.member.model.dto.StoreMemberDTO;

public interface MypageService {
    int updateEmpPwd(EmployeeDTO emp);

    int updateStorePwd(StoreMemberDTO store);
}
