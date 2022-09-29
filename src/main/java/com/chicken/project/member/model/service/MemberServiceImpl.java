package com.chicken.project.member.model.service;

import com.chicken.project.email.common.MailHandler;
import com.chicken.project.email.common.TempKey;
import com.chicken.project.member.model.dao.EmployeeMapper;
import com.chicken.project.member.model.dao.StoreMemberMapper;
import com.chicken.project.member.model.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final EmployeeMapper employeeMapper;

    private final StoreMemberMapper storeMapper;



    @Autowired
    public MemberServiceImpl(EmployeeMapper employeeMapper, StoreMemberMapper storeMapper) {

        this.employeeMapper = employeeMapper;
        this.storeMapper = storeMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("[EmployeeService]================================= ");
        log.info("[EmployeeService] empId = " + username);

        EmployeeDTO empMember = employeeMapper.selectEmpInfo(username);
        StoreMemberDTO storeMember = storeMapper.selectStoreInfo(username);

        log.info("[EmployeeService] member = " + empMember);
        log.info("[EmployeeService] storeMember = " + storeMember);

        AdminImpl member = null;
        StoreImpl store = null;
        if(empMember != null){

            List<GrantedAuthority> authorities = new ArrayList<>();

            if(empMember.getEmpRoleList() != null) {
                log.info("[empMember] check = " + empMember);
                List<EmpRoleDTO> roleList = empMember.getEmpRoleList();

                for(int i = 0; i < roleList.size(); i++){

                    AuthDTO authority = roleList.get(i).getAuthority();
                    authorities.add(new SimpleGrantedAuthority(authority.getAuthName()));
                }
            }

            member = new AdminImpl(empMember.getEmpId(), empMember.getEmpPwd(), authorities);
            member.setDetails(empMember);

        } else if(storeMember != null){
            log.info("[storeMember] check = " + storeMember);
            List<GrantedAuthority> authorities = new ArrayList<>();

            if(storeMember.getStoreRoleList() != null){

                List<StoreRoleDTO> roleList = storeMember.getStoreRoleList();

                for(int i = 0; i < roleList.size(); i++){

                    AuthDTO authority = roleList.get(i).getAuthority();
                    authorities.add(new SimpleGrantedAuthority(authority.getAuthName()));
                }
            }

            store = new StoreImpl(storeMember.getStoreId(), storeMember.getStorePwd(), authorities);
            store.setDetails(storeMember);
            log.info("[storeMember] check = " + store);
        }

        return member != null? member: store;

    }


}
