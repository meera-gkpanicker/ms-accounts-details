package com.anz.accounts.details.service;

import com.anz.accounts.details.api.AccountsDetailsResponse;
import com.anz.accounts.details.api.Status;
import com.anz.accounts.details.exception.AccountsDetailException;
import com.anz.accounts.details.repository.AccountRepository;
import com.anz.accounts.details.repository.AccountTransactionRepository;
import com.anz.accounts.details.repository.dto.Account;
import com.anz.accounts.details.repository.dto.AccountTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountsDetailsService {

    private final AccountRepository accountRepository;
    private final AccountTransactionRepository accountTransactionRepository;

    public AccountsDetailsResponse getAccountsList() {
        List<Account> accountList = accountRepository.findAll();
        if(CollectionUtils.isEmpty(accountList)) {
            throw new AccountsDetailException("There are no accounts present:", Status.NOT_FOUND);
        }
        return AccountsDetailsResponse.builder().accountsList(accountList).build();
    }

    public AccountsDetailsResponse getTransactionsByAccount(String accountNumber) {
        List<AccountTransaction> accountTransactionList = accountTransactionRepository.findByAccountNumber(accountNumber);
        if(CollectionUtils.isEmpty(accountTransactionList)) {
            throw new AccountsDetailException("There are no transactions found for this account.", Status.NOT_FOUND);
        }

        return AccountsDetailsResponse.builder().accountTransactionList(accountTransactionList).build();
    }
}
