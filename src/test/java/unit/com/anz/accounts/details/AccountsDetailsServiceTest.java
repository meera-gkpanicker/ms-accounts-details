package unit.com.anz.accounts.details;

import com.anz.accounts.details.api.Status;
import com.anz.accounts.details.exception.AccountsDetailException;
import com.anz.accounts.details.repository.AccountRepository;
import com.anz.accounts.details.repository.AccountTransactionRepository;
import com.anz.accounts.details.repository.dto.Account;
import com.anz.accounts.details.repository.dto.AccountTransaction;
import com.anz.accounts.details.service.AccountsDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AccountsDetailsServiceTest {

    @InjectMocks
    private AccountsDetailsService accountsDetailsService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountTransactionRepository accountTransactionRepository;

    @Test
    public void testGetTransactionsByAccountNumberThrowException() {
        List<AccountTransaction> accountTransactionList = new ArrayList<>();
        when(accountTransactionRepository.findByAccountNumber(anyString())).thenReturn(accountTransactionList);
        AccountsDetailException exception = assertThrows(AccountsDetailException.class, () -> accountsDetailsService.getTransactionsByAccount("1111"));
        assertEquals(exception.getMessage(), "There are no transactions found for this account.");
        assertEquals(exception.getStatus(), Status.NOT_FOUND);
    }

    @Test
    public void testGetAccountsListThrowException() {
        List<Account> accountList = new ArrayList<>();
        when(accountRepository.findAll()).thenReturn(accountList);
        AccountsDetailException exception = assertThrows(AccountsDetailException.class, () -> accountsDetailsService.getAccountsList());
        assertEquals(exception.getMessage(), "There are no accounts present:");
        assertEquals(exception.getStatus(), Status.NOT_FOUND);
    }
}
