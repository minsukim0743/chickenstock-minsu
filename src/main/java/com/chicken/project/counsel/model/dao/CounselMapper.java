package com.chicken.project.counsel.model.dao;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.counsel.model.dto.CounselApplyDTO;
import com.chicken.project.counsel.model.dto.CounselDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CounselMapper {
    int insertCounsel(CounselDTO counsel);

    List<CounselDTO> selectCounsel(SelectCriteria selectCriteria);

    CounselDTO selectCounselByNo(int counselNo);

    int insertCounselApply(String answerContent, int counselNo, String empName);

    void updateCounsel(int counselNo);

    CounselApplyDTO selectCounselApplyByNo(int counselNo);

    List<CounselDTO> selectCounselByStoreName(String storeName);

    int selectTotalCount();
}
