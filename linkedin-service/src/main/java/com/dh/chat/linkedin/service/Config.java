package com.dh.chat.linkedin.service;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Marvin Tola
 * @email mtolapacheco@gmail.com
 */
@Configuration
@EnableFeignClients
@ComponentScan("com.dh.chat.linkedin.service")
public class Config {
}
