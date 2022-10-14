package com.chicken.project.account.model.service;

import com.chicken.project.account.model.dto.AccountApplyDTO;
import com.chicken.project.account.model.dto.AccountDTO;
import com.chicken.project.account.model.dto.StoreBreakdownDTO;
import com.chicken.project.account.model.dto.StoreDepositDTO;
import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.store.model.dto.BalanceDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface AccountService {

    /* 본사 가맹점 입금신청 조회 */
    List<AccountApplyDTO> selectAccountApplyList(SelectCriteria selectCriteria);

    /* 가맹점 잔액 조회 */
    BalanceDTO selectBalance(String storeName);

    /* 가맹점 입금신청 */
    int accountInsert(int accountDeposit, String storeName);

    /* 가맹점명으로 입금신청 조회 */
    List<AccountDTO> selectAccountListByStoreName(String storeName);

    /* 가맹점 입금 반려 */
    int accountApplyUpdate2(int depositNum);

    /* 가맹점 잔액 수정 */
    int balanceUpdate(AccountApplyDTO accountApply, int accountDeposit, String storeName);

    /* 본사 가맹점 잔액 조회 */
    List<BalanceDTO> balanceSelect();

    /* 가맹점 입금액 조회 */
    List<StoreDepositDTO> selectStoreDeposit(String storeName);

    /* 가맹점 출금액 조회 */
    List<StoreBreakdownDTO> selectStoreBreakdown(String storeName);

    /* 페이징을 위한 전체 개수 조회 */
    int selectTotalCount();
}
