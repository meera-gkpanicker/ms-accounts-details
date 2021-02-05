package com.anz.accounts.details.controller;

import com.anz.accounts.details.api.AccountsDetailsResponse;
import com.anz.accounts.details.service.AccountsDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = APPLICATION_JSON_VALUE)
public class AccountsDetailsController {

    private static final String GET_ACCOUNTS_LIST = "/accounts/list";
    private static final String GET_ACCOUNT_BY_NUMBER = "/accounts/{accountNumber}";

    private final AccountsDetailsService accountsDetailsService;

    @GetMapping(GET_ACCOUNTS_LIST)
    public ResponseEntity<AccountsDetailsResponse> getAccountsList(final HttpServletRequest httpServletRequest,
                                                                   @RequestHeader final HttpHeaders requestHeaders) {
        return new ResponseEntity<>(accountsDetailsService.getAccountsList(), HttpStatus.OK);
    }

    @GetMapping(GET_ACCOUNT_BY_NUMBER)
    public ResponseEntity<AccountsDetailsResponse> getTransactionsByAccount(@PathVariable final String accountNumber,
                                                                            final HttpServletRequest httpServletRequest,
                                                                   @RequestHeader final HttpHeaders requestHeaders) {
        return new ResponseEntity<>(accountsDetailsService.getTransactionsByAccount(accountNumber), HttpStatus.OK);
    }
}
