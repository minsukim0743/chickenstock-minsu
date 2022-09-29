package com.chicken.project.counsel.model.service;

import com.chicken.project.counsel.model.dto.CounselApplyDTO;
import com.chicken.project.counsel.model.dto.CounselDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CounselService {
    void insertCounsel(CounselDTO counsel);

    List<CounselDTO> selectCounsel();

    CounselDTO selectCounselByNo(int counselNo);

    void insertCounselApply(String answerContent, int counselNo, String empName);

    CounselApplyDTO selectCounselApplyByNo(int counselNo);

    List<CounselDTO> selectCounselByStoreName(String storeName);
}
