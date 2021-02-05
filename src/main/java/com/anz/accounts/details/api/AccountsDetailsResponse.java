package com.anz.accounts.details.api;

import com.anz.accounts.details.repository.dto.Account;
import com.anz.accounts.details.repository.dto.AccountTransaction;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class AccountsDetailsResponse {

    List<Account> accountsList;
    List<AccountTransaction> accountTransactionList;
}
