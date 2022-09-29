package com.chicken.project.billTax.model.service;

import com.chicken.project.billTax.model.dto.BillTaxDTO;
import com.chicken.project.billTax.model.dto.tsBillTaxDTO;
import com.chicken.project.common.paging.SelectCriteria;

import java.util.List;
import java.util.Map;

public interface BillTaxService {
    // 세금계산서 페이징+리스트
    List<BillTaxDTO> selectBillList(SelectCriteria selectCriteria);

    // 세금계산서 가맹점 페이징+리스트
    List<BillTaxDTO> selectTaxBillList(SelectCriteria selectCriteria);

    // 페이징을 위한 전체 게시글 카운트
    int selectTotalCount(Map<String, String> searchMap);

    // 세금계산서별 물품리스트
    List<BillTaxDTO> selectTaxMenuList(String recCode);

    // 거래명세서 페이징+리스트
    List<tsBillTaxDTO> selectTsList(SelectCriteria selectCriteria);

    // 거래명세서 가맹점 페이징+리스트
    List<tsBillTaxDTO> selectTsBillTaxList(SelectCriteria selectCriteria);

    // 거래명세서별 물품리스트
    List<tsBillTaxDTO> selectTsMenuList(String recCode);

    int selectTotalCountS(Map<String, String> searchMap);
}
