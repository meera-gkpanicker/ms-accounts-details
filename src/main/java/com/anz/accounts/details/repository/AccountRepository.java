package com.anz.accounts.details.repository;

import com.anz.accounts.details.repository.dto.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {


}
