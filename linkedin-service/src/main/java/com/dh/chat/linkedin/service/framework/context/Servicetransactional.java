package com.dh.chat.linkedin.service.framework.context;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Marvin Tola
 * @email mtolapacheco@gmail.com
 */
@Service
@Scope("prototype")
@Transactional
@Retention(RetentionPolicy.RUNTIME)
public @interface Servicetransactional {
}
