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

    /* 유저 1:1 문의 작성하기 */
    @Override
    @Transactional
    public void insertCounsel(CounselDTO counsel) {

        int result = counselMapper.insertCounsel(counsel);

    }

    /* 1:1 문의 리스트 조회하기 */
    @Override
    public List<CounselDTO> selectCounsel(SelectCriteria selectCriteria) {

        return counselMapper.selectCounsel(selectCriteria);
    }

    /* 1:1 문의 인덱스로 해당 게시글 내용 조회하기 */
    @Override
    public CounselDTO selectCounselByNo(int counselNo) {

        return counselMapper.selectCounselByNo(counselNo);
    }

    /* 관리자 1:1 문의 답변 등록하기 */
    @Override
    @Transactional
    public void insertCounselApply(String answerContent, int counselNo, String empName) {

        int result = counselMapper.insertCounselApply(answerContent, counselNo, empName);

        if(result > 0){

            /* 1:1 문의 답변 등록 성공 시 counsel 상태 '답변 완료'로 변경 */
            counselMapper.updateCounsel(counselNo);
        }
    }

    /* 1:1 문의 인덱스로 해당 1:1 문의 답변 내용 조회 */
    @Override
    public CounselApplyDTO selectCounselApplyByNo(int counselNo) {

        return counselMapper.selectCounselApplyByNo(counselNo);
    }

    /* 현재 로그인 계정 1:1 문의 리스트 조회하기 */
    @Override
    public List<CounselDTO> selectCounselByStoreName(String storeName) {

        return counselMapper.selectCounselByStoreName(storeName);
    }

    /* 페이징을 위한 전체 개수 조회 */
    @Override
    public int selectTotalCount() {

        return counselMapper.selectTotalCount();
    }
}
