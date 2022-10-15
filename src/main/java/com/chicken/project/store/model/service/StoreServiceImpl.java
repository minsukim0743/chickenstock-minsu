package com.chicken.project.store.model.service;

import com.chicken.project.exception.store.StoreDeleteException;
import com.chicken.project.exception.store.StoreInsertException;
import com.chicken.project.exception.store.StoreUpdateException;
import com.chicken.project.store.model.dao.StoreMapper;
import com.chicken.project.store.model.dto.StoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("storeService")
public class StoreServiceImpl implements StoreService{

    private final StoreMapper storeMapper;

    @Autowired
    public StoreServiceImpl(StoreMapper storeMapper){

        this.storeMapper = storeMapper;
    }
    /* 가맹점 조회 */
    @Override
    public List<StoreDTO> storeList() {

        /* 가맹점 리스트 조회 */
        return storeMapper.storeList();
    }

    /* 가맹점 삭제 */
    @Override
    @Transactional
    public int deleteStore(String storeName) {

        /* 가맹점 정보 삭제 */
        int result = storeMapper.deleteStore(storeName);

        return result;
    }

    /* 가맹점 등록 */
    @Override
    @Transactional
    public int insertStore(StoreDTO store) throws StoreInsertException {

        /* 가맹점 등록 */
        int result = storeMapper.insertStore(store);

        if(!(result > 0)){

            throw new StoreInsertException("가맹점 등록 실패!");
        } else {

            /* 가맹점 등록 성공 시 해당 가맹점 잔액 테이블 생성 */
            int result2 = storeMapper.insertBalance(store.getStoreName(), store.getStoreId());

            if(result2 > 0){

                /* 해당 가맹점 잔액 테이블 생성 성공 시 가맹점 권한부여 */
                int result3 = storeMapper.insertStoreRole(store.getStoreName(), store.getStoreId());
            }
        }

        return result;
    }

    /* 가맹점 명을 받아 가맹점 정보 조회 */
    @Override
    public StoreDTO selectStoreByName(String storeName) {

        return storeMapper.selectStoreByName(storeName);
    }

    /* 가맹점 정보 수정 */
    @Override
    @Transactional
    public int updateStore(StoreDTO store) {

        int result = storeMapper.updateStore(store);

        return result;
    }
}
