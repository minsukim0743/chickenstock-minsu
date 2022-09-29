package com.chicken.project.notice.model.dao;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.notice.model.dto.NoticeDTO;
import com.chicken.project.notice.model.dto.NoticeFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {
    List<NoticeDTO> selectAllList();

    int noticeInsert(NoticeDTO notice);

    int noticeFileInsert(NoticeFileDTO noticeFile);

    NoticeDTO noticeDetailByNo(int noticeNo);

    int deleteNotice(int noticeNo);

    int deleteNoticeFile(int noticeNo);

    int selectTotalCount(Map<String, String> searchMap);

    List<NoticeDTO> selectNoticeList(SelectCriteria selectCriteria);

    NoticeFileDTO selectFileByName(int noticeNo);

    int updateNotice(NoticeDTO notice);

    int updateNoticeFile(NoticeFileDTO noticeFile);

    int incrementNoticeCount(int noticeNo);

    List<NoticeDTO> selectMainNotice();
}
