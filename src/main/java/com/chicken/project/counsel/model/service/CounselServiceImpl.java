package com.chicken.project.counsel.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.counsel.model.dao.CounselMapper;
import com.chicken.project.counsel.model.dto.CounselApplyDTO;
import com.chicken.project.counsel.model.dto.CounselDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("counselService")
public class CounselServiceImpl implements CounselService{

    private final CounselMapper counselMapper;

    @Autowired
    public CounselServiceImpl(CounselMapper counselMapper){

        this.counselMapper = counselMapper;
    }
    @Override
    @Transactional
    public void insertCounsel(CounselDTO counsel) {

        int result = counselMapper.insertCounsel(counsel);

    }
    @Override
    public List<CounselDTO> selectCounsel(SelectCriteria selectCriteria) {

        return counselMapper.selectCounsel(selectCriteria);
    }

    @Override
    public CounselDTO selectCounselByNo(int counselNo) {

        return counselMapper.selectCounselByNo(counselNo);
    }

    @Override
    @Transactional
    public void insertCounselApply(String answerContent, int counselNo, String empName) {

        int result = counselMapper.insertCounselApply(answerContent, counselNo, empName);

        if(result > 0){

            counselMapper.updateCounsel(counselNo);
        }
    }

    @Override
    public CounselApplyDTO selectCounselApplyByNo(int counselNo) {

        return counselMapper.selectCounselApplyByNo(counselNo);
    }

    @Override
    public List<CounselDTO> selectCounselByStoreName(String storeName) {

        return counselMapper.selectCounselByStoreName(storeName);
    }

    @Override
    public int selectTotalCount() {

        return counselMapper.selectTotalCount();
    }
}
