package com.dh.chat.linkedin.service.model.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Marvin Tola
 * @email mtolapacheco@gmail.com
 */
@Data
@Entity
@Table(name = "user_table")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @Column(name = "userid",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name",length = 100,nullable = false)
    private String name;

    @Column(name = "age",nullable = false)
    private Long age;

    @Column(name = "email",length = 100,nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender",length = 100,nullable = false)
    private TypeGender gender;

    @Column(name = "numberphone",nullable = false)
    private Long numberphone;

    @OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "accountid",referencedColumnName = "id",nullable = false)
    private Account account;
}
