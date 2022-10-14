package com.chicken.project.counsel.model.dao;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.counsel.model.dto.CounselApplyDTO;
import com.chicken.project.counsel.model.dto.CounselDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CounselMapper {

    /* 유저 1:1 문의 작성하기 */
    int insertCounsel(CounselDTO counsel);

    /* 1:1 문의 리스트 조회하기 */
    List<CounselDTO> selectCounsel(SelectCriteria selectCriteria);

    /* 1:1 문의 인덱스로 해당 게시글 내용 조회하기 */
    CounselDTO selectCounselByNo(int counselNo);

    /* 관리자 1:1 문의 답변 등록하기 */
    int insertCounselApply(String answerContent, int counselNo, String empName);

    /* 1:1 문의 답변 등록 성공 시 counsel 상태 '답변 완료'로 변경 */
    void updateCounsel(int counselNo);

    /* 1:1 문의 인덱스로 해당 1:1 문의 답변 내용 조회 */
    CounselApplyDTO selectCounselApplyByNo(int counselNo);

    /* 현재 로그인 계정 1:1 문의 리스트 조회하기 */
    List<CounselDTO> selectCounselByStoreName(String storeName);

    /* 페이징을 위한 전체 개수 조회 */
    int selectTotalCount();
}
