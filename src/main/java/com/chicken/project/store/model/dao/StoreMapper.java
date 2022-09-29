package com.chicken.project.store.model.dao;

import com.chicken.project.store.model.dto.StoreDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Mapper
public interface StoreMapper {
    List<StoreDTO> storeList();
    int deleteStore(String storeName);

    int insertStore(StoreDTO store);

    StoreDTO selectStoreInfo(String username);

    StoreDTO selectStoreByName(String storeName);

    int updateStore(StoreDTO store);

    String selectStoreId(UserDetails member);

    int insertBalance(String storeName, String storeId);

    int insertStoreRole(String storeName, String storeId);

}
