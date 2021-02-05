package com.anz.accounts.details.exception;

import com.anz.accounts.details.api.Status;
import lombok.Data;

@Data
public class AccountsDetailException extends RuntimeException {

    private Status status;

    public AccountsDetailException(String msg) { super(msg); }

    public AccountsDetailException(String msg, Status status) {
        super(msg);
        this.status = status;
    }
}
