package com.chicken.project.notice.model.service;


import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.exception.notice.NoticeDeleteException;
import com.chicken.project.exception.notice.NoticeInsertException;
import com.chicken.project.exception.notice.NoticeUpdateException;
import com.chicken.project.notice.model.dao.NoticeMapper;
import com.chicken.project.notice.model.dto.NoticeDTO;
import com.chicken.project.notice.model.dto.NoticeFileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

    private final NoticeMapper noticeMapper;

    @Autowired
    public NoticeServiceImpl(NoticeMapper noticeMapper){

        this.noticeMapper = noticeMapper;
    }

    /* 공지사항 등록 */
    @Override
    @Transactional
    public int noticeInsert(NoticeDTO notice) throws NoticeInsertException {

        int result = noticeMapper.noticeInsert(notice);

        if(!(result > 0)) {

            throw new NoticeInsertException("공지사항 등록 실패!");
        }

        return result;
    }

    /* 공지사항 파일 등록*/
    @Override
    @Transactional
    public int noticeFileInsert(NoticeFileDTO noticeFile) {

        return noticeMapper.noticeFileInsert(noticeFile);
    }

    /* 공지사항 상세페이지 조회 */
    @Override
    public NoticeDTO noticeDetailByNo(int noticeNo) {

        NoticeDTO noticeDetail = null;

        int result = noticeMapper.incrementNoticeCount(noticeNo);

        if(result > 0){

            noticeDetail = noticeMapper.noticeDetailByNo(noticeNo);
        }

        return noticeDetail;
    }

    /* 공지사항 삭제 */
    @Override
    @Transactional
    public int deleteNotice(int noticeNo) throws NoticeDeleteException {

        int result =  noticeMapper.deleteNoticeFile(noticeNo);
        int result2 = noticeMapper.deleteNotice(noticeNo);

        if(!(result2 > 0)){

            throw new NoticeDeleteException("공지사항 삭제 실패!");
        }

        return result;
    }


    /* 공지사항 수정 */
    @Override
    @Transactional
    public int updateNotice(NoticeDTO notice) throws NoticeUpdateException {

        int result = noticeMapper.updateNotice(notice);

        if(notice.getNoticeFile() != null){

            int deleteFileResult = noticeMapper.deleteNoticeFile(notice.getNoticeFile().getNoticeNo());

            if(deleteFileResult > 0){
                NoticeFileDTO noticeFile = notice.getNoticeFile();
                noticeFile.setNoticeNo(notice.getNoticeFile().getNoticeNo());

                int insertFileResult = noticeMapper.noticeFileInsert(noticeFile);
            }
        }

        return result;
    }

    /* 공지사항 전체 글 개수 조회 */
    @Override
    public int selectTotalCount(Map<String, String> searchMap) {

        int result = noticeMapper.selectTotalCount(searchMap);

        return result;
    }

    /* 공지사항 글 조회 */
    @Override
    public List<NoticeDTO> selectNoticeList(SelectCriteria selectCriteria) {

        List<NoticeDTO> noticeList = noticeMapper.selectNoticeList(selectCriteria);

        return noticeList;
    }


    /* 공지사항 파일 수정 */
    @Override
    @Transactional
    public int updateNoticeFile(NoticeFileDTO noticeFile) {

        return noticeMapper.updateNoticeFile(noticeFile);
    }


    /* 공지사항 파일 삭제 */
    @Override
    @Transactional
    public int deleteNoticeFile(int noticeNo) {

        return noticeMapper.deleteNoticeFile(noticeNo);
    }

    @Override
    public List<NoticeDTO> selectMainNotice() {

        return noticeMapper.selectMainNotice();
    }
}
