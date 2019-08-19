package com.dh.chat.linkedin.service.service;

import com.dh.chat.linkedin.service.framework.context.Servicetransactional;
import com.dh.chat.linkedin.service.input.AccountCreateInput;
import com.dh.chat.linkedin.service.model.domain.Account;
import com.dh.chat.linkedin.service.model.repositories.AccountRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Marvin Tola
 * @email mtolapacheco@gmail.com
 */
@Servicetransactional
public class AccountCreateService {

    @Setter
    private AccountCreateInput input;

    @Autowired
    private AccountRepository accountRepository;

    @Getter
    private Account account;

    public void execute(){
        Account accountInstance = composeAccount();
        account=accountRepository.save(accountInstance);
    }

    private Account composeAccount() {
        Account instance =new Account();
        instance.setUsername(input.getUsername());
        instance.setPassword(input.getPassword());

        return instance;
    }
}
