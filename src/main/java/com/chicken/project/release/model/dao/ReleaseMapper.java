package com.chicken.project.release.model.dao;

import com.chicken.project.release.model.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReleaseMapper {
    List<ReleaseOrderDTO> releaseOrderSelect(ReleaseSelectCriteria releaseSelectCriteria);
    List<ReleaseOrderDTO> releaseOrderSelectN();
    List<ReleaseDTO> releaseDtoOrderSelect();

    int releaseItemUpdateN(ReleaseItemDTO releaseOrderDTO);

    int cartYnUpdateR(ReleaseCartDTO releaseCartDTO);

    int cartYnUpdateN(ReleaseCartDTO releaseCartDTO);

    Integer totalMoneySelect(Integer intRelCode);

    int releaseInsert(ReleaseDTO relDto);

    int releaseItemUpdateF();

    int releaseItemInsert(ReleaseItemInfoDTO releaseItemInfoDTO, ReleaseItemDTO releaseItemDTO, StoreOrderDTO storeOrderDTO, ReleaseCartDTO releaseCartDTO, int relCode, int totalItemMoney);
    int releaseItemDelete(ReleaseItemInfoDTO releaseItemInfoDTO, ReleaseCartDTO releaseCartDTO, ReleaseItemDTO releaseItemDTO, StoreOrderDTO storeOrderDTO, int relCode);

    List<ReleaseDTO> releaseSelect(ReleaseSelectCriteria selectCriteria);
    List<ReleaseOrderDTO> releaseSelect2(int relCode);

    int itemAmountUpdate(Map<String, Integer> itemAmountUpdate);

    int relItemHistoryInsert(Map<String, Integer> itemAmountUpdate);

    int releaseItemUpdateY(Map<String, Integer> itemAmountUpdate);

    List<ReleaseItemDTO> relItemSelectY(int relCode);

    int relYnUpdate(int relCode);

    ReleaseOrderDTO relItemDetailSelect(int relCodeDetail);

    int itemHistoryInsert(int relCode, int itemNo);

    int totalCount(ReleaseSelectCriteria selectCriteria);

    int releaseInsertHandler(int cartNo, int relCodeDetail);

    ReleaseDetailDTO selectDetail(String relCodeDetail);
}
