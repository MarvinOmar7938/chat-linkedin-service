package com.dh.chat.linkedin.service.controller.api;

import com.dh.chat.linkedin.service.input.AccountCreateInput;
import com.dh.chat.linkedin.service.model.domain.Account;
import com.dh.chat.linkedin.service.service.AccountCreateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Marvin Tola
 * @email mtolapacheco@gmail.com
 */
@Api(tags = "account",description ="operations over accounts")
@RestController
@RequestMapping("/public/accounts")
@RequestScope
public class AccountController {

    @Autowired
    private AccountCreateService accountCreateService;

    @ApiOperation(value = "create account")

    @RequestMapping(method = RequestMethod.POST)
    public Account createAccount(@RequestBody AccountCreateInput input){
        accountCreateService.setInput(input);
        accountCreateService.execute();

        return accountCreateService.getAccount();
    }
}
