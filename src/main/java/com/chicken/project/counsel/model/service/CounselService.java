package com.chicken.project.counsel.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.counsel.model.dto.CounselApplyDTO;
import com.chicken.project.counsel.model.dto.CounselDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CounselService {
    void insertCounsel(CounselDTO counsel);

    List<CounselDTO> selectCounsel(SelectCriteria selectCriteria);

    CounselDTO selectCounselByNo(int counselNo);

    void insertCounselApply(String answerContent, int counselNo, String empName);

    CounselApplyDTO selectCounselApplyByNo(int counselNo);

    List<CounselDTO> selectCounselByStoreName(String storeName);

    int selectTotalCount();
}
