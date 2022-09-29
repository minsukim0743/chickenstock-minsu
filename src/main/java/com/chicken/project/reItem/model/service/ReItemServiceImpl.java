package com.chicken.project.reItem.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.reItem.model.dao.ReItemMapper;
import com.chicken.project.reItem.model.dto.ReItemDTO;
import com.chicken.project.reItem.model.dto.ReListDTO;
import com.chicken.project.reItem.model.dto.StoreItemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("reItemService")
public class ReItemServiceImpl implements ReItemService{

    public ReItemMapper reItemMapper;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ReItemServiceImpl(ReItemMapper reItemMapper) { this.reItemMapper = reItemMapper; }

    // 페이징
    @Override
    public int selectTotalCount(Map<String, String> searchMap) {

        int result = reItemMapper.selectTotalCount(searchMap);

        return result;
    }

    // 가맹점 반품서 리스트보기
    @Override
    public List<ReListDTO> selectReList(SelectCriteria selectCriteria) {


        List<ReListDTO> reList = reItemMapper.selectReList(selectCriteria);

        return reList;
    }

    @Override
    public List<ReListDTO> selectReturnList(SelectCriteria selectCriteria) {

        List<ReListDTO> returnList = reItemMapper.selectReturnList(selectCriteria);

        return returnList;
    }

    // 본사 반품 상세보기
    @Override
    public ReItemDTO selectReturnItem(String rNo) {

        ReItemDTO reItem = reItemMapper.selectReturnItem(rNo);

        return reItem;
    }

    @Override
    public List<ReItemDTO> selectReturnItems(String rNo) {

        List<ReItemDTO> reItems = reItemMapper.selectReItems(rNo);

        return reItems;
    }

    @Override
    public List<StoreItemDTO> selectItem(String storeName) {

        List<StoreItemDTO> storeItems = reItemMapper.selectItem(storeName);

        return storeItems;
    }

    // 가맹점 반품신청
    @Override
    @Transactional
    public int insertReItem(List<ReItemDTO> insertItem, String storeName) {

        int result = 0;

        result = reItemMapper.insertReturnItems(insertItem.get(0));

        if(result > 0){

            log.info("result 확인 : " + result);
            result = 0; //초기화


            List<Map<String, Object>> reList = new ArrayList<>();
            for(int i =0; i < insertItem.size(); i++){
                Map<String, Object> maps = new HashMap<>();
                maps.put("returnCount", insertItem.get(i).getReturnCount());
                maps.put("itemNo", insertItem.get(i).getItemNo());
                maps.put("storeName", storeName);
                reList.add(maps);
                result = reItemMapper.insertRItem(maps);
            }

            if(result > 0) {

                result = 0;

                Map<String, Object> map = null;

                for(int i =0; i < reList.size(); i++) {

                    map = reList.get(i);

                    result = reItemMapper.updateAcount(map);
                }
                if (result > 0) {

                    result = 0;

                    result = reItemMapper.insertProgress(insertItem.get(0));
                }
            }
        }

        return result;
    }
    // 본사 반품승인
    @Transactional
    @Override
    public int updateComplete(ReItemDTO returnItems, String adminId, String rNo, String storeName) {

        Map<String, Object> map = new HashMap<>();
        map.put("adminId", adminId);
        map.put("rNo", Integer.parseInt(rNo));

        int result = 0;

        result = reItemMapper.updateComplete(map);  //본사 progress update

        if(result > 0){

            result = 0;

            result = reItemMapper.updateProgress(Integer.parseInt(rNo));  // 대기 -> 반품완료

            if(result > 0){

                result = 0;


                Map<String, Object> maps = new HashMap<>();
                maps.put("rNo", Integer.parseInt(rNo));
                maps.put("storeName", storeName);
                maps.put("returnTotalMoney", returnItems.getReturnTotalMoney());

                result = reItemMapper.updateMoney(maps);    // 예치금 올려주기

                if(result > 0){

                    result = 0;
                    result = reItemMapper.insertDeposit(maps);
                }
            }

        }

        return result;
    }

    @Override
    public List<ReItemDTO> selectList(String rNo) {

        List<ReItemDTO> re = reItemMapper.selectRItem(rNo);

        return re;

    }

    @Override
    @Transactional
    public int updateItem(Map<String, Object> maps) {

        int result = 0;

        for (int i = 0; i < ((List<ReItemDTO>) maps.get("check")).size(); i++) {

            ReItemDTO reItem = ((List<ReItemDTO>) maps.get("check")).get(i);
            reItem.setrNo(Integer.parseInt((String) maps.get("rNo")));
            result = reItemMapper.upDateItem(reItem);


            if(result > 0){

                result = 0;

                result = reItemMapper.insertHistory(reItem);

                if(result > 0){

                    result = 0;

                    result = reItemMapper.updateRProgress(reItem);
                }
            }
        }
        return result;
    }

    @Override
    @Transactional
    public int deleteList(String rNo) {

        int result = 0;

        result = reItemMapper.deleteProgress(rNo);

        if(result > 0 ){

            result = 0;

            result = reItemMapper.deleteRItem(rNo);

            if(result > 0 ){

                result = 0;

                result = reItemMapper.deleteReturnItems(rNo);
            }
        }

        return result;
    }

    // 가맹점 반품서 수정
    @Override
    @Transactional
    public ReItemDTO selectUpReItem(String rNo) {

        ReItemDTO upReItem = reItemMapper.selectUpReItem(rNo);

        return upReItem;
    }

    @Override
    public List<ReItemDTO> selectReItems(Map<String, String> item) {

        List<ReItemDTO> reUpItems = reItemMapper.selectUpReItems(item);

        return reUpItems;
    }

    @Override
    public List<StoreItemDTO> selectItems(Map<String, String> item) {

        List<StoreItemDTO> storeItems = reItemMapper.selectItems(item);

        return storeItems;
    }

    // 가맹점 반품서 상세보기
    @Override
    public ReItemDTO viewReItem(String rNo) {

        ReItemDTO viewReItem = reItemMapper.selectViewReItem(rNo);

        return viewReItem;
    }

    @Override
    public List<ReItemDTO> viewReItems(Map<String, String> viewItem) {

        List<ReItemDTO> viewReItems = reItemMapper.selectViewReItems(viewItem);

        return viewReItems;
    }

    // 상품 하나 추가하기
    @Override
    public  int insertOneItem(Map<String, Object> insertItem) {

        int insertOne = reItemMapper.insertOneItem(insertItem);

        log.info("insertItem",insertItem);

        return insertOne;
    }

    // 상품 하나 지우기
    @Override
    public int deleteOneItem(Map<String, Object> deleteItem) {

        int updateMoney = reItemMapper.updateOneMoney(deleteItem);

        if(updateMoney > 0){
            int insertCount = reItemMapper.updateItemCount(deleteItem);


            if( insertCount > 0 ) {

                int deleteOne = reItemMapper.deleteOneItem(deleteItem);
            }
        }
        return updateMoney;
    }

    @Override
    @Transactional
    public int updateReItem(List<ReItemDTO> updateItem, String storeName) {

        int result1 = 0;
//
        Map<String, Object> up = new HashMap<>();
        up.put("returnTotalMoney", updateItem.get(0).getReturnTotalMoney());
        up.put("rNo", updateItem.get(0).getrNo());
        up.put("rReason", updateItem.get(0).getrReason());

        result1 = reItemMapper.updateReturnItems(up);
        log.info("값이 들어올까요>?" + result1);

        if(result1 > 0){

            List<Map<String, Object>> upList = new ArrayList<>();

            for(int i =0; i < updateItem.size(); i++){

                Map<String, Object> maps = new HashMap<>();
                maps.put("returnCount", updateItem.get(i).getFirstCount());
                maps.put("itemNo", updateItem.get(i).getItemNo());
                maps.put("storeName", storeName);
                maps.put("rNo", updateItem.get(i).getrNo());
                maps.put("returnItemNo", updateItem.get(i).getReturnItemNo());
                upList.add(maps);

            }

            int result2 = 0;
            if(result1 > 0) {

                for(int i =0; i < upList.size(); i++) {
                    Map<String, Object> maps = upList.get(i);
                    Map<String, Object> map = new HashMap<>();
                    result2 = reItemMapper.updateRItem(maps);

                    if(result2 >0) {
                        int P = updateItem.get(i).getReturnCount(); //고정값
                        int M = updateItem.get(i).getFirstCount();  //변화값
                        map.put("itemNo", maps.get("itemNo"));
                        map.put("rNo", maps.get("rNo"));
                        map.put("storeName",maps.get("storeName"));

                        log.info("P야 나와라 : " + P);
                        log.info("M야 나와라 : " + M);
                        int result3 = 0;
                            if (P > M) {

                                int V = P - M;
                                map.put("V", V);
                                result3 = reItemMapper.updateReAcountP(map); //수량을 줄였을 때 +
                                log.info("값이 들어올까요>!>!>!>?" + result3);
                            } else if (M > P) {

                                int R = M - P;
                                map.put("R", R);
                                log.info("이제 확인용 말을 쓸게 없어요" + map);
                                result3 = reItemMapper.updateReAcountM(map); // 수량을 늘렸을때 -
                                log.info("값이 들어올까요>!>>!>!>>!>!>!>!>?" + result3);
                            }

                    }
                }
            }
        }

        return result1;
    }

    @Override
    public int selectTotalCountS(Map<String, String> searchMap) {

        int result = reItemMapper.selectTotalCountS(searchMap);

        return result;
    }
}
