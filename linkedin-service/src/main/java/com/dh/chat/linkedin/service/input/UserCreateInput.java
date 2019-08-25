package com.dh.chat.linkedin.service.input;

import com.dh.chat.linkedin.service.model.domain.Account;
import com.dh.chat.linkedin.service.model.domain.TypeGender;
import lombok.Data;

/**
 * @author Marvin Tola
 * @email mtolapacheco@gmail.com
 */
@Data
public class UserCreateInput {

    private String name;

    private Long age;

    private String email;

    private TypeGender gender;

    private Long numberphone;

    private Long accountid;
}
