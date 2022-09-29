package com.chicken.project.storeItem.model.dao;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.storeItem.model.dto.StoreItemListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StoreItemMapper {
    List<StoreItemListDTO> itemListSelect(SelectCriteria selectCriteria);

    int selectTotalCount(Map<String, String> searchMap);

    int storeItemUpdate(String storeName, String itemNo, String storeAmount);

    int amountSelect(String storeName, String itemNo);

    List<StoreItemListDTO> selectMainStoreItem(String storeName);
}
