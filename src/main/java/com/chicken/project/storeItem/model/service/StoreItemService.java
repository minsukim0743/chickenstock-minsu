package com.chicken.project.storeItem.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.storeItem.model.dto.StoreItemListDTO;

import java.util.List;
import java.util.Map;

public interface StoreItemService {
    List<StoreItemListDTO> itemListSelect(SelectCriteria selectCriteria);
    int selectTotalCount(Map<String, String> searchMap);
    int storeItemUpdate(String storeName, String itemNo, String storeAmount);
    int amountSelect(String storeName, String itemNo);
    List<StoreItemListDTO> selectMainStoreItem(String storeName);
}
