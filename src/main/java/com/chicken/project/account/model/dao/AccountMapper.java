package com.chicken.project.account.model.dao;

import com.chicken.project.account.model.dto.AccountApplyDTO;
import com.chicken.project.account.model.dto.AccountDTO;
import com.chicken.project.account.model.dto.StoreBreakdownDTO;
import com.chicken.project.account.model.dto.StoreDepositDTO;
import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.store.model.dto.BalanceDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AccountMapper {

    /* 본사 가맹점 입금신청 조회 */
    List<AccountApplyDTO> selectAccountApplyList(SelectCriteria selectCriteria);

    /* 가맹점 잔액 조회 */
    BalanceDTO selectBalance(String storeName);

    /* 가맹점 입금신청 시 입금신청 정보 등록 */
    int accountInsert(int accountDeposit, String storeName);

    /* 가맹점 입금신청 성공 시 관리자 입금신청 정보 등록 */
    int accountApplyInsert(String storeName);

    /* 가맹점명으로 입금신청 조회 */
    List<AccountDTO> selectAccountListByStoreName(String storeName);

    /* 입금 승인 시 해당 store 잔액 수정 */
    int balanceUpdate(AccountApplyDTO accountApply, int accountDeposit, String storeName);

    /* 가맹점 입금 반려 시 입금신청 상태 '반려'로 변경 */
    int accountApplyUpdate2(int depositNum);

    /* 가맹점 입금 반려 시 관리자 입금신청 상태 '반려'로 변경 */
    int accountUpdate2(int depositNum);

    /* 입금 승인 시 입금신청 상태 '승인'으로 변경 */
    int accountApplyUpdate(AccountApplyDTO accountApply);

    /* 입금 승인 시 관리자 입금신청 상태 '승인'으로 변경 */
    int accountUpdate(AccountApplyDTO accountApply);

    /* 관리자 가맹점 잔액 조회 */
    List<BalanceDTO> balanceSelect();

    /* 관리자 가맹점 입금액 조회 */
    List<StoreDepositDTO> selectStoreDeposit(String storeName);

    /* 가맹점 출금액 조회 */
    List<StoreBreakdownDTO> selectStoreBreakdown(String storeName);

    /* 입금 승인 시 해당 store 입금내역 추가 */
    int depositInsert(int accountDeposit, String storeName);

    /* 페이징을 위한 전체 개수 조회 */
    int selectTotalCount();
}
