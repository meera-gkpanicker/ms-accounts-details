package component.com.anz.accounts.details;

import com.anz.accounts.details.MsAccountsDetailsApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({SpringExtension.class})
@SpringBootTest(classes = MsAccountsDetailsApplication.class)
@AutoConfigureMockMvc
public class AccountsDetailsControllerTest {

    @Autowired
    MockMvc mockMvc;
    String getAcctsListUrl = "/accounts/list";



    @Test
    public void testGetAcctsListReturnSuccess() throws Exception {

        mockMvc.perform(get(getAcctsListUrl)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .header("content-type", MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testGetTransactionsByAccountNumber() throws Exception {
        String getTransactionUrl = "/accounts/123456";
        mockMvc.perform(get(getTransactionUrl)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}
