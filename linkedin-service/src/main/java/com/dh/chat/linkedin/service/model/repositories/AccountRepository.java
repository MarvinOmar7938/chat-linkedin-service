package com.dh.chat.linkedin.service.model.repositories;

import com.dh.chat.linkedin.service.model.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marvin Tola
 * @email mtolapacheco@gmail.com
 */
public interface AccountRepository extends JpaRepository<Account,Long> {
}
