package unit.com.anz.accounts.details;

import com.anz.accounts.details.api.AccountsDetailsResponse;
import com.anz.accounts.details.controller.AccountsDetailsController;
import com.anz.accounts.details.repository.dto.AccountTransaction;
import com.anz.accounts.details.service.AccountsDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AccountsDetailsControllerTest {

    @InjectMocks
    private AccountsDetailsController accountsDetailsController;

    @Mock
    private AccountsDetailsService accountsDetailsService;

    private HttpHeaders httpHeaders;

    @BeforeEach
    public void setUp() {
        httpHeaders = new HttpHeaders();
        httpHeaders.add("content-type", MediaType.APPLICATION_JSON_VALUE);
    }

    @Test
    public void testGetAccountsListReturnSuccess() {
        when(accountsDetailsService.getAccountsList()).thenReturn(new AccountsDetailsResponse());
        ResponseEntity<AccountsDetailsResponse> responseEntity = accountsDetailsController.getAccountsList(new MockHttpServletRequest(), httpHeaders);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(accountsDetailsService, times(1)).getAccountsList();
    }

    @Test
    public void testGetTransactionsByAccountReturnSuccess() {

        AccountsDetailsResponse accountsDetailsResponse = AccountsDetailsResponse.builder().accountTransactionList(Collections.singletonList(AccountTransaction.builder().build())).build();
        when(accountsDetailsService.getTransactionsByAccount(anyString())).thenReturn(accountsDetailsResponse);

        ResponseEntity<AccountsDetailsResponse> responseEntity = accountsDetailsController.getTransactionsByAccount("123456", new MockHttpServletRequest(), httpHeaders);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(accountsDetailsService, times(1)).getTransactionsByAccount(anyString());
    }

    @Test
    public void testGetTransactionsByAccountReturnNotFound() {

        AccountsDetailsResponse accountsDetailsResponse = AccountsDetailsResponse.builder().accountTransactionList(Collections.singletonList(AccountTransaction.builder().build())).build();
        when(accountsDetailsService.getTransactionsByAccount(anyString())).thenReturn(accountsDetailsResponse);

        ResponseEntity<AccountsDetailsResponse> responseEntity = accountsDetailsController.getTransactionsByAccount("123456", new MockHttpServletRequest(), httpHeaders);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(accountsDetailsService, times(1)).getTransactionsByAccount(anyString());
    }


}
