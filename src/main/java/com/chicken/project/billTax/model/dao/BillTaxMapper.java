package com.chicken.project.billTax.model.dao;

import com.chicken.project.billTax.model.dto.BillTaxDTO;
import com.chicken.project.billTax.model.dto.tsBillTaxDTO;
import com.chicken.project.common.paging.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BillTaxMapper {
    List<BillTaxDTO> selectBillTaxList(SelectCriteria selectCriteria);

    int selectTotalCount(Map<String, String> searchMap);

    List<BillTaxDTO> selectTaxMenuList(String recCode);

    List<tsBillTaxDTO> selectTsBillTaxList(SelectCriteria selectCriteria);

    List<tsBillTaxDTO> selectTsMenuList(String recCode);

    List<BillTaxDTO> selectBillList(SelectCriteria selectCriteria);

    List<tsBillTaxDTO> selectTsList(SelectCriteria selectCriteria);

    int selectTotalCountS(Map<String, String> searchMap);
}
