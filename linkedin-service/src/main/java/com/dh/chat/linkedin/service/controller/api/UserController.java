package com.dh.chat.linkedin.service.controller.api;

import com.dh.chat.linkedin.service.input.UserCreateInput;
import com.dh.chat.linkedin.service.model.domain.User;
import com.dh.chat.linkedin.service.service.UserCreateService;
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
@Api(tags = "user",description = "operation over user")
@RequestMapping("/public/users")
@RestController
@RequestScope
public class UserController {

    @Autowired
    private UserCreateService userCreateService;

    @ApiOperation(value = "create a user")

    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody UserCreateInput input){
        userCreateService.setInput(input);
        userCreateService.execute();
        return userCreateService.getUser();
    }
}
