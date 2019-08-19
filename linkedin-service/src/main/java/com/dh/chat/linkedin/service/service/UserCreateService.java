package com.dh.chat.linkedin.service.service;

import com.dh.chat.linkedin.service.framework.context.Servicetransactional;
import com.dh.chat.linkedin.service.input.AccountCreateInput;
import com.dh.chat.linkedin.service.input.UserCreateInput;
import com.dh.chat.linkedin.service.model.domain.Account;
import com.dh.chat.linkedin.service.model.domain.User;
import com.dh.chat.linkedin.service.model.repositories.AccountRepository;
import com.dh.chat.linkedin.service.model.repositories.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Marvin Tola
 * @email mtolapacheco@gmail.com
 */
@Servicetransactional
public class UserCreateService {

    @Setter
    private UserCreateInput input;

    @Setter
    private AccountCreateInput inputaccount;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Getter
    private User user;

    public void execute(){
        Account account=composeAccountInstance();
        account=accountRepository.save(account);

        User userInstance=composeUserInstance(account);
        user=userRepository.save(userInstance);
    }

    private Account composeAccountInstance() {
//        Account instance =new Account();
//        instance.setUsername(inputaccount.getUsername());
//        instance.setPassword(inputaccount.getPassword());
//        return instance;
        return accountRepository.findById(input.getAccountid()).get();
    }
    private User composeUserInstance(Account account) {
        User instance=new User();
        instance.setName(input.getName());
        instance.setAge(input.getAge());
        instance.setEmail(input.getEmail());
        instance.setGender(input.getGender());
        instance.setNumberphone(input.getNumberphone());
        instance.setAccount(account);

        return instance;
    }
}
