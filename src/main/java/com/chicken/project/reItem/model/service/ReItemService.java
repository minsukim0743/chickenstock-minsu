package com.chicken.project.reItem.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.reItem.model.dto.ReItemDTO;
import com.chicken.project.reItem.model.dto.ReListDTO;
import com.chicken.project.reItem.model.dto.StoreItemDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface ReItemService {
    // 페이징
    int selectTotalCount(Map<String, String> searchMap);

    // 가맹점 반품서 리스트보기
    List<ReListDTO> selectReList(SelectCriteria selectCriteria);

    List<ReListDTO> selectReturnList(SelectCriteria selectCriteria);

    // 본사 반품 상세보기
    ReItemDTO selectReturnItem(String rNo);

    List<ReItemDTO> selectReturnItems(String rNo);

    List<StoreItemDTO> selectItem(String storeName);

    // 가맹점 반품신청
    @Transactional
    int insertReItem(List<ReItemDTO> insertItem, String storeName);

    // 본사 반품승인
    @Transactional
    int updateComplete(ReItemDTO returnItems, String adminId, String rNo, String storeName);

    List<ReItemDTO> selectList(String rNo);

    @Transactional
    int updateItem(Map<String, Object> maps);

    @Transactional
    int deleteList(String rNo);

    // 가맹점 반품서 수정
    @Transactional
    ReItemDTO selectUpReItem(String rNo);

    List<ReItemDTO> selectReItems(Map<String, String> item);

    List<StoreItemDTO> selectItems(Map<String, String> item);

    ReItemDTO viewReItem(String rNo);

    List<ReItemDTO> viewReItems(Map<String, String> viewItem);

    int insertOneItem(Map<String, Object> insertItem);

    // 상품 하나 지우기
    int deleteOneItem(Map<String, Object> deleteItem);

    @Transactional
    int updateReItem(List<ReItemDTO> updateItem, String storeName);

    int selectTotalCountS(Map<String, String> searchMap);
}
