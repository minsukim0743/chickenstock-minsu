package com.chicken.project.account.model.service;

import com.chicken.project.account.model.dao.AccountMapper;
import com.chicken.project.account.model.dto.AccountApplyDTO;
import com.chicken.project.account.model.dto.AccountDTO;
import com.chicken.project.account.model.dto.StoreBreakdownDTO;
import com.chicken.project.account.model.dto.StoreDepositDTO;
import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.store.model.dto.BalanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

    private final AccountMapper accountMapper;

    @Autowired
    public AccountServiceImpl(AccountMapper accountMapper){

        this.accountMapper = accountMapper;
    }

    /* 본사 가맹점 입금신청 조회 */
    @Override
    public List<AccountApplyDTO> selectAccountApplyList(SelectCriteria selectCriteria) {

        return accountMapper.selectAccountApplyList(selectCriteria);
    }


    /* 가맹점 잔액 조회 */
    @Override
    public BalanceDTO selectBalance(String storeName) {

        return accountMapper.selectBalance(storeName);
    }

    /* 가맹점 입금신청 */
    @Override
    @Transactional
    public int accountInsert(int accountDeposit, String storeName) {

        /* 가맹점 입금신청 시 입금신청 정보 등록 */
        int result = accountMapper.accountInsert(accountDeposit, storeName);

        if(result > 0) {

            /* 가맹점 입금신청 성공 시 관리자 입금신청 정보 등록 */
            int result2 = accountMapper.accountApplyInsert(storeName);
        }

        return result;
    }

    /* 가맹점명으로 입금신청 조회 */
    @Override
    public List<AccountDTO> selectAccountListByStoreName(String storeName) {

        return accountMapper.selectAccountListByStoreName(storeName);
    }

    /* 가맹점 입금 반려 */
    @Override
    @Transactional
    public int accountApplyUpdate2(int depositNum) {

        /* 가맹점 입금 반려 시 입금신청 상태 '반려'로 변경 */
        int result = accountMapper.accountApplyUpdate2(depositNum);

        if(result > 0){

            /* 가맹점 입금 반려 시 관리자 입금신청 상태 '반려'로 변경 */
            int result2 = accountMapper.accountUpdate2(depositNum);
        }

        return result;
    }

    /* 가맹점 잔액 수정 */
    @Override
    @Transactional
    public int balanceUpdate(AccountApplyDTO accountApply, int accountDeposit, String storeName) {

        /* 입금 승인 시 해당 store 잔액 수정 */
        int result = accountMapper.balanceUpdate(accountApply, accountDeposit, storeName);

        if(result > 0){

            /* 입금 승인 시 입금신청 상태 '승인'으로 변경 */
            int result2 = accountMapper.accountApplyUpdate(accountApply);

            if(result2 > 0){

                /* 입금 승인 시 관리자 입금신청 상태 '승인'으로 변경 */
                int result3 = accountMapper.accountUpdate(accountApply);

                if(result3 > 0 ){

                    /* 입금 승인 시 해당 store 입금내역 추가 */
                    int result4 = accountMapper.depositInsert(accountDeposit, storeName);
                }
            }
        }

        return result;
    }

    /* 관리자 가맹점 잔액 조회 */
    @Override
    public List<BalanceDTO> balanceSelect() {

        return accountMapper.balanceSelect();
    }

    /* 관리자 가맹점 입금액 조회 */
    @Override
    public List<StoreDepositDTO> selectStoreDeposit(String storeName) {

        return accountMapper.selectStoreDeposit(storeName);
    }

    /* 가맹점 출금액 조회 */
    @Override
    public List<StoreBreakdownDTO> selectStoreBreakdown(String storeName) {

        return accountMapper.selectStoreBreakdown(storeName);
    }

    /* 페이징을 위한 전체 개수 조회 */
    @Override
    public int selectTotalCount() {

        return accountMapper.selectTotalCount();
    }
}
