package com.chicken.project.release.model.service;

import com.chicken.project.release.model.dao.ReleaseMapper;
import com.chicken.project.release.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ReleaseServiceImpl implements ReleaseService{

    private final ReleaseMapper releaseMapper;

    @Autowired
    public ReleaseServiceImpl(ReleaseMapper releaseMapper){

        this.releaseMapper = releaseMapper;
    }

    @Override
    public List<ReleaseOrderDTO> releaseOrderSelect(ReleaseSelectCriteria releaseSelectCriteria) {

        List<ReleaseOrderDTO> orderDTO = releaseMapper.releaseOrderSelect(releaseSelectCriteria);

        System.out.println(orderDTO);
        return orderDTO;
    }

    @Override
    public List<ReleaseOrderDTO> releaseOrderSelectN() {

        List<ReleaseOrderDTO> orderDTO = releaseMapper.releaseOrderSelectN();

        return orderDTO;
    }

    @Override
    public List<ReleaseDTO> releaseDtoOrderSelect() {

        List<ReleaseDTO> releaseDTO = releaseMapper.releaseDtoOrderSelect();

        return releaseDTO;
    }

    @Override
    @Transactional
    public int releaseItemInsert(ReleaseItemInfoDTO releaseItemInfoDTO, ReleaseItemDTO releaseItemDTO, StoreOrderDTO storeOrderDTO, ReleaseCartDTO releaseCartDTO, int relCode, int totalItemMoney) {
        int result = releaseMapper.releaseItemInsert(releaseItemInfoDTO, releaseItemDTO, storeOrderDTO, releaseCartDTO, relCode, totalItemMoney);

        return result;
    }

    @Override
    @Transactional
    public int cartYnUpdateR(ReleaseCartDTO releaseCartDTO) {

        int result = releaseMapper.cartYnUpdateR(releaseCartDTO);

        return result;
    }

    @Override
    @Transactional
    public int releaseItemUpdateN(ReleaseItemDTO releaseItemDTO) {

        int result = releaseMapper.releaseItemUpdateN(releaseItemDTO);

        return result;
    }

    @Override
    @Transactional
    public int cartYnUpdateN(ReleaseCartDTO releaseCartDTO) {

        int result = releaseMapper.cartYnUpdateN(releaseCartDTO);

        return result;
    }

    @Override
    @Transactional
    public int releaseItemDelete(ReleaseItemInfoDTO releaseItemInfoDTO, ReleaseCartDTO releaseCartDTO, ReleaseItemDTO releaseItemDTO, StoreOrderDTO storeOrderDTO, int relCode) {

        int result = releaseMapper.releaseItemDelete(releaseItemInfoDTO, releaseCartDTO, releaseItemDTO, storeOrderDTO,  relCode);

        return result;
    }

    @Override
    public Integer totalMoneySelect(Integer intRelCode) {

        Integer totalMoney = releaseMapper.totalMoneySelect(intRelCode);

        return totalMoney;
    }

    @Override
    @Transactional
    public int releaseInsert(ReleaseDTO relDto) {

        int releaseInsert = releaseMapper.releaseInsert(relDto);

        return releaseInsert;
    }

    @Override
    @Transactional
    public int releaseItemUpdateF() {

        int releaseUpdate = releaseMapper.releaseItemUpdateF();

        return releaseUpdate;
    }

    @Override
    public List<ReleaseDTO> releaseSelect(ReleaseSelectCriteria selectCriteria) {

        List<ReleaseDTO> releaseSelect = releaseMapper.releaseSelect(selectCriteria);

        return releaseSelect;
    }

    @Override
    public List<ReleaseOrderDTO> releaseSelect2(int relCode) {

        List<ReleaseOrderDTO> releaseItemListSelect = releaseMapper.releaseSelect2(relCode);

        return releaseItemListSelect;
    }

    @Override
    @Transactional
    public int itemAmountUpdate(Map<String, Integer> itemAmountUpdate) {

        int result = releaseMapper.itemAmountUpdate(itemAmountUpdate);

        return result;
    }

    @Override
    @Transactional
    public int relItemHistoryInsert(Map<String, Integer> itemAmountUpdate) {

        int result = releaseMapper.relItemHistoryInsert(itemAmountUpdate);

        return result;
    }

    @Override
    @Transactional
    public int releaseItemUpdateY(Map<String, Integer> itemAmountUpdate) {

        int result = releaseMapper.releaseItemUpdateY(itemAmountUpdate);

        return result;
    }

    @Override
    @Transactional
    public List<ReleaseItemDTO> relItemSelectY(int relCode) {

        List<ReleaseItemDTO> relItemSelectY = releaseMapper.relItemSelectY(relCode);

        return relItemSelectY;
    }

    @Override
    @Transactional
    public int relYnUpdate(int relCode) {

        int relYnResult = releaseMapper.relYnUpdate(relCode);
        return relYnResult;
    }

    @Override
    public ReleaseOrderDTO relItemDetailSelect(int relCodeDetail) {

        ReleaseOrderDTO relItemDetailAjax = releaseMapper.relItemDetailSelect(relCodeDetail);

        return relItemDetailAjax;
    }

    @Override
    @Transactional
    public int itemHistoryInsert(int relCode, int itemNo) {

        int result = releaseMapper.itemHistoryInsert(relCode, itemNo);

        return result;
    }

    @Override
    public int totalCount(ReleaseSelectCriteria selectCriteria) {

        int result = releaseMapper.totalCount(selectCriteria);

        return result;
    }

    @Override
    public int releaseInsertHandler(int cartNo, int relCodeDetail) {

        int result = releaseMapper.releaseInsertHandler(cartNo, relCodeDetail);

        return result;
    }

    @Override
    public ReleaseDetailDTO selectDetail(String relCodeDetail) {

        ReleaseDetailDTO selectDetail = releaseMapper.selectDetail(relCodeDetail);
        System.out.println("service.selectDetail : " + selectDetail);
        return selectDetail;
    }
}
