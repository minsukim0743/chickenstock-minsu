package com.chicken.project.store.model.dao;

import com.chicken.project.store.model.dto.StoreDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Mapper
public interface StoreMapper {

    /* 가맹점 조회 */
    List<StoreDTO> storeList();

    /* 가맹점 삭제 */
    int deleteStore(String storeName);

    /* 가맹점 등록 */
    int insertStore(StoreDTO store);

    /* 가맹점 명을 받아 가맹점 정보 조회 */
    StoreDTO selectStoreByName(String storeName);

    /* 가맹점 정보 수정 */
    int updateStore(StoreDTO store);

    /* 가맹점 잔액 테이블 생성 */
    int insertBalance(String storeName, String storeId);

    /* 가맹점 등록 시 권한 부여 */
    int insertStoreRole(String storeName, String storeId);

}
