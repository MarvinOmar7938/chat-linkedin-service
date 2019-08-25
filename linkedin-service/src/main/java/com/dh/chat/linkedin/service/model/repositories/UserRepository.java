package com.dh.chat.linkedin.service.model.repositories;

import com.dh.chat.linkedin.service.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marvin Tola
 * @email mtolapacheco@gmail.com
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
