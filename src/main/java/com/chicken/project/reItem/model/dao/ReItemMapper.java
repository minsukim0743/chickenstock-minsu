package com.chicken.project.reItem.model.dao;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.reItem.model.dto.ReItemDTO;
import com.chicken.project.reItem.model.dto.ReListDTO;
import com.chicken.project.reItem.model.dto.StoreItemDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReItemMapper {

    // 페이징
    int selectTotalCount(Map<String, String> searchMap);
    // 가맹점 반품서 리스트 확인
    List<ReListDTO> selectReList(SelectCriteria selectCriteria);

    // 본사로 들어온 반품서 리스트
    List<ReListDTO> selectReturnList(SelectCriteria selectCriteria);

    ReItemDTO selectReturnItem(String rNo);

    List<ReItemDTO> selectReItems(String rNo);

    List<StoreItemDTO> selectItem(String storeName);

    int insertReturnItems(ReItemDTO reItemDTO);

    int insertRItem(Map<String, Object> maps);


    int insertProgress(ReItemDTO reItemDTO);

    int updateComplete(Map<String, Object> map);


    int updateMoney(Map<String, Object> maps);

    int updateProgress(int parseInt);

    List<ReItemDTO> selectRItem(String rNo);

    int upDateItem(ReItemDTO reItem);

    int insertHistory(ReItemDTO reItem);

    int updateRProgress(ReItemDTO reItem);

    int deleteProgress(String rNo);

    int deleteRItem(String rNo);

    int deleteReturnItems(String rNo);

    int updateAcount(Map<String, Object> maps);

    int insertDeposit(Map<String, Object> maps);

    ReItemDTO selectUpReItem(String rNo);

    List<ReItemDTO> selectUpReItems(Map<String, String> item);

    List<StoreItemDTO> selectItems(Map<String, String> item);

    ReItemDTO selectViewReItem(String rNo);

    List<ReItemDTO> selectViewReItems(Map<String, String> viewItem);

    int insertOneItem(Map<String, Object> insertItem);

    int deleteOneItem(Map<String, Object> deleteItem);

    int updateOneMoney(Map<String, Object> deleteItem);

    int updateItemCount(Map<String, Object> deleteItem);

    int updateReturnItems(Map<String, Object> up);

    int updateRItem(Map<String, Object> maps);

    int updateReAcountP(Map<String, Object> map);

    int updateReAcountM(Map<String, Object> map);

    int selectTotalCountS(Map<String, String> searchMap);
}
