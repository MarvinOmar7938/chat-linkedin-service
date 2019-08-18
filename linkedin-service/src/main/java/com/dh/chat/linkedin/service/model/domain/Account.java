package com.dh.chat.linkedin.service.model.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Marvin Tola
 * @email mtolapacheco@gmail.com
 */
@Data
@Entity
@Table(name = "account_table")
public class Account {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "username",length = 100,nullable = false)
    private String username;

    @Column(name = "password",length = 100,nullable = false)
    private String password;

}
