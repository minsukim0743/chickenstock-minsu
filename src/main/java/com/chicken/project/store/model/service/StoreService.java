package com.chicken.project.store.model.service;

import com.chicken.project.exception.store.StoreDeleteException;
import com.chicken.project.exception.store.StoreInsertException;
import com.chicken.project.exception.store.StoreUpdateException;
import com.chicken.project.store.model.dto.StoreDTO;

import java.util.List;

public interface StoreService {
    /* 가맹점 조회 */
    List<StoreDTO> storeList();

    /* 가맹점 삭제 */
    int deleteStore(String storeName);

    /* 가맹점 등록 */
    int insertStore(StoreDTO store) throws StoreInsertException;

    /* 가맹점 명을 받아 가맹점 조회 */
    StoreDTO selectStoreByName(String storeName);

    /* 가맹점 정보 수정 */
    int updateStore(StoreDTO store);
}
