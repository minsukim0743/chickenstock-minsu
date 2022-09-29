package com.chicken.project.member.model.dao;

import com.chicken.project.member.model.dto.StoreMemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMemberMapper {
    StoreMemberDTO selectStoreInfo(String username);

    int updateStorePwd(StoreMemberDTO store);
}
