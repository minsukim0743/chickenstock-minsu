package com.chicken.project.mypage.service;

import com.chicken.project.member.model.dao.EmployeeMapper;
import com.chicken.project.member.model.dao.StoreMemberMapper;
import com.chicken.project.member.model.dto.EmployeeDTO;
import com.chicken.project.member.model.dto.StoreMemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MypageServiceImpl implements MypageService{

    private final EmployeeMapper employeeMapper;
    private final StoreMemberMapper storeMapper;

    @Autowired
    public MypageServiceImpl(EmployeeMapper employeeMapper, StoreMemberMapper storeMapper) {
        this.employeeMapper = employeeMapper;
        this.storeMapper = storeMapper;
    }


    @Override
    public int updateEmpPwd(EmployeeDTO emp) {

        int result = employeeMapper.updateEmpPwd(emp);

        return result;
    }

    @Override
    public int updateStorePwd(StoreMemberDTO store) {

        int result = storeMapper.updateStorePwd(store);

        return result;
    }
}
