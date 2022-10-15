package com.chicken.project.notice.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.exception.notice.NoticeDeleteException;
import com.chicken.project.exception.notice.NoticeInsertException;
import com.chicken.project.exception.notice.NoticeUpdateException;
import com.chicken.project.notice.model.dto.NoticeDTO;
import com.chicken.project.notice.model.dto.NoticeFileDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface NoticeService {

    /* 공지사항 등록 */
    int noticeInsert(NoticeDTO notice);

    /* 공지사항 파일 등록*/
    int noticeFileInsert(NoticeFileDTO noticeFile);

    /* 공지사항 상세페이지 조회 */
    NoticeDTO noticeDetailByNo(int noticeNo);

    /* 공지사항 삭제 */
    int deleteNotice(int noticeNo);

    /* 공지사항 수정 */
    int updateNotice(NoticeDTO notice);

    /* 공지사항 전체 글 개수 조회 */
    int selectTotalCount(Map<String, String> searchMap);

    /* 공지사항 리스트 조회 */
    List<NoticeDTO> selectNoticeList(SelectCriteria selectCriteria);

    /* 공지사항 첨부파일 수정 */
    int updateNoticeFile(NoticeFileDTO noticeFile);

    /* 공지사항 첨부파일 삭제 */
    int deleteNoticeFile(int noticeNo);

    /* 메인페이지 공지사항 조회 */
    List<NoticeDTO> selectMainNotice();
}
